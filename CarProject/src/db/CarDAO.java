package db;
//실제 데이터베이스에서 전체 차량 검색및 DB작업

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CarDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	/* DB연결 메소드 */
	public void getCon() {
		try {
			// 1.WAS서버와 연결된 DBApp웹프로젝트의 모든 정보를 가지고 있는 컨텍스트객체 생성
			Context init = new InitialContext();

			// 2.연결된 WAS서버에서 DataSource(커넥션풀) 검색해서 가져오기
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspbeginner");

			// DataSource(커넥션풀)에서 DB연동객체 (커넥션) 가져오기
			con = ds.getConnection(); // DB연결

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// getCon()메소드 끝

	// 렌트 주문 현황을 DB에 저장하는 메소드
	public void insertCarOrder(CarOrderBean bean) {
		try {
			// 커넥션 풀에서 DB연결객체 빌려오기
			getCon();

			// 쿼리 준비 insert
			String sql = "insert into carorder(carno,carqty,carreserveday,"
					+ "carbegindate,carins,carwifi,carnave,carbabyseat,memberphone,memberpass) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";

			// 쿼리실행할 pstmt반환
			pstmt = con.prepareStatement(sql);
			// ?값 10개 셋팅
			pstmt.setInt(1, bean.getCarno());
			pstmt.setInt(2, bean.getCarqty());
			pstmt.setInt(3, bean.getCarreserveday());
			pstmt.setString(4, bean.getCarbegindate());
			pstmt.setInt(5, bean.getCarins());
			pstmt.setInt(6, bean.getCarwifi());
			pstmt.setInt(7, bean.getCarnave());
			pstmt.setInt(8, bean.getCarbabyseat());
			pstmt.setString(9, bean.getMemberphone());
			pstmt.setString(10, bean.getMemberpass());

			// insert쿼리 실행
			pstmt.executeUpdate();

			// 디비연결객체 반납
			con.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println("insertCarOrder메소드 쿼리 오류 : " + e);
			e.printStackTrace();
		}
	}// insertCarOrder메소드 끝

	/* 전체 차량 보기 메소드 작성 */
	public Vector<CarListBean> getAllCarlist() {

		// CarListBean객체를 저장할 Vector객체 생성
		Vector<CarListBean> v = new Vector<CarListBean>();

		// 하나의 레코드를 저장할 객체를 담을 참조변수 선언
		CarListBean bean = null;

		try {
			// DB연결 객체 하나 얻기
			getCon();
			// 쿼리 준비 : 전체 차량 레코드 검색
			String sql = "select * from carlist";
			// select쿼리를 실행할수 있는 객체 반환
			pstmt = con.prepareStatement(sql);

			// 쿼리 실행후 결과를 리턴 rs에 저장
			rs = pstmt.executeQuery();

			// 반복문을 돌면서 CarListBean클래스에 검색한 데이터 저장
			while (rs.next()) {
				// new CarListBean()객체 생성
				bean = new CarListBean();
				// CarListBean객체에 검색한 차번호 저장
				bean.setCarno(rs.getInt(1));
				// CarListBean객체에 검색한 차이름 저장
				bean.setCarname(rs.getString(2));
				// CarListBean객체에 검색한 차제조사 저장
				bean.setCarcompany(rs.getString(3));
				// CarListBean객체에 검색한 차가격 저장
				bean.setCarprice(rs.getInt("carprice"));
				// CarListBean객체에 검색한 차인승 저장
				bean.setCarusepeople(rs.getInt(5));
				// CarListBean객체에 검색한 차정보 저장
				bean.setCarinfo(rs.getString(6));
				// CarListBean객체에 검색한 차이미지명 저장
				bean.setCarimg(rs.getString(7));
				// CarListBean객체에 검색한 차종류(대형,중형,소형) 저장
				bean.setCarcategory(rs.getString(8));
				// 다저장된 CarListBean객체를 백터에 추가
				v.add(bean);

			}

		} catch (Exception e) {
			System.out.println("getAllCarlist()에서 쿼리 오류  :" + e);
		} finally {
			// 자원해제
		}
		// 백터 리턴
		return v;
	}

	/* 카테고리별 자동차레코드 데이터 검색 메소드 */
	public Vector<CarListBean> getCategoryList(String carcategory) {
		// 리턴할 Vector객체 생성
		Vector<CarListBean> v = new Vector<CarListBean>();
		// 하나의 자동차레코드를 저장할 객체을 담을 변수 선언
		CarListBean bean = null;

		try {
			// 커넥션 풀 안에 있는 ...DB연결 객체 빌려오기
			getCon();

			// 쿼리 준비 : 카테고리별 차량 검색
			String sql = "select * from carlist where carcategory=?";

			// 쿼리를 실행할수 있는 객체 얻기
			pstmt = con.prepareStatement(sql);
			// ?값 셋팅
			pstmt.setString(1, carcategory);
			// 쿼리 실행후 검색 결과를 리턴 ResultSet에 저장
			rs = pstmt.executeQuery();

			// 반복문을 돌면서 CarListBean클래스에 검색한 데이터 저장
			while (rs.next()) {
				// new CarListBean()객체 생성
				bean = new CarListBean();
				// CarListBean객체에 검색한 차번호 저장
				bean.setCarno(rs.getInt(1));
				// CarListBean객체에 검색한 차이름 저장
				bean.setCarname(rs.getString(2));
				// CarListBean객체에 검색한 차제조사 저장
				bean.setCarcompany(rs.getString(3));
				// CarListBean객체에 검색한 차가격 저장
				bean.setCarprice(rs.getInt("carprice"));
				// CarListBean객체에 검색한 차인승 저장
				bean.setCarusepeople(rs.getInt(5));
				// CarListBean객체에 검색한 차정보 저장
				bean.setCarinfo(rs.getString(6));
				// CarListBean객체에 검색한 차이미지명 저장
				bean.setCarimg(rs.getString(7));
				// CarListBean객체에 검색한 차종류(대형,중형,소형) 저장
				bean.setCarcategory(rs.getString(8));
				// 다저장된 CarListBean객체를 백터에 추가
				v.add(bean);

			}

		} catch (Exception e) {
			System.out.println("getCategoryList메소드 오류 : " + e);

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return v;
	}

	/* 하나의 자동차 정보를 리턴하는 메소드 */
	public CarListBean getOneCar(int carno) {
		// 리턴할 하나의 레코드를 저장할 CarListBean객체를 담을 참조변수 선언
		CarListBean bean = null;

		try {
			// 커넥션풀안에 있는 DB연결객체 빌려오기
			getCon();
			// 쿼리 준비 : 매개변수로 전달받은 차넘버에 해당하는 차량 레코드 검색
			String sql = "select * from carlist where carno=?";

			// ?를 제외한 쿼리를 담은 pstmt 반환
			pstmt = con.prepareStatement(sql);

			// ?값 -> 차넘버 셋팅
			pstmt.setInt(1, carno);

			// 쿼리 실행후 결과를 리턴 rs에 저장
			rs = pstmt.executeQuery();

			// 반복문을 돌면서 CarListBean객체에 컬럼데이터를 저장
			while (rs.next()) {
				bean = new CarListBean();
				// 차번호 저장
				bean.setCarno(rs.getInt(1));
				// 차이름 저장
				bean.setCarname(rs.getString("carname"));
				// 차제조사 저장
				bean.setCarcompany(rs.getString(3));
				// 차가격 저장
				bean.setCarprice(rs.getInt(4));
				// 차인승 저장
				bean.setCarusepeople(rs.getInt(5));
				// 차정보 저장
				bean.setCarinfo(rs.getString(6));
				// 차이미지명 저장
				bean.setCarimg(rs.getString(7));
				// 차종류(소형,대형,중형) 중하나 저
				bean.setCarcategory(rs.getString(8));
			}

		} catch (Exception e) {
			System.out.println(" getOneCar 메소드 쿼리 오류 : " + e);

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// CarListBean객체 리턴
		return bean;
	}

	/*
	 * 예약확인 페이지에서.. 렌트카 예약시 작성한.... 전화번호와, 패스워드에 해당하는 예약한 주문정보를 모두 가져오는 메소드
	 */
	public Vector<Carconfirmbean> getAllCarOrder(String memberphone, String memberpass) {

		// 렌트예약 정보를 담고 있는 각각의 Carconfirmbean객체를 담기위한 컬렉션 객체 생성
		Vector<Carconfirmbean> v = new Vector<Carconfirmbean>();
		// DB에서 검색한 렌트예약 정보객체(CarConfirmbean객체)를 저장할 참조 변수 선언
		Carconfirmbean bean = null;

		try {
			// DB연결
			getCon();

			// 렌트예약한 날자가 현재날짜보다 크고,
			// 렌트예약시 작성한 비회원 전화번호와 패스워드에 해당하는 렌트예약정보를 검색하는데..
			// cororder테이블과 carlist테이블을 natural 조인하여 검색.
			String sql = "select * from carorder natural join carlist where "
					+ "now() <  str_to_date(carbegindate, '%Y-%m-%d') and " + "memberphone=? and memberpass=?";

			// 참고 !! Select 문에 *와같이 별도의 컬럼 순서를 지정하지 않으면..
			// natural 조인의 기준이 되는 컬럼들이 다른컬럼보다 먼저 출력된다.
			// 이때 natural 조인은 join에 사용된 같은 이름의 컬럼을 중복출력하지 않고 하나로 출력한다.

			// ?를 제외한 select구문을 담은 Pstmt를 반환
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberphone); // ?값 셋팅 : 예약시 작성한 전화번호
			pstmt.setString(2, memberpass);// ?값 셋팅 : 예약시 작성한 비밀번호

			// select한 렌트예약정보를 담고 있는 ResultSet객체 리턴 하여 저장
			rs = pstmt.executeQuery();

			// 렌트 예약 정보 하나하나를 new CarConfirmBean()객체에 저장
			while (rs.next()) {
				bean = new Carconfirmbean(); // dto객체 생성
				// 주문 id 담기
				bean.setOrderid(rs.getInt(2));
				// 렌트예약한 대여수량
				bean.setCarqty(rs.getInt(3));
				// 대여한 기간
				bean.setCarreserveday(rs.getInt(4));
				// 자동차를 대여한 날짜
				bean.setCarbegindate(rs.getString(5));
				// 보험적용 일수 저장
				bean.setCarins(rs.getInt(6));
				// 무선 wifi 적용 일수 저장
				bean.setCarwifi(rs.getInt(7));
				// 네비게이션 적용 일수 저장
				bean.setCarnave(rs.getInt(8));
				// 베이비시트
				bean.setCarbabyseat(rs.getInt(9));
				// 렌트예약한 자동차 이름 저장
				bean.setCarname(rs.getString(12));
				// 렌트예약한 자동차 가격 저장
				bean.setCarprice(rs.getInt(14));
				// 렌트예약한 자동차 이미지명 저장
				bean.setCarimg(rs.getString(17));

				v.add(bean); // 백터에 담기

			}
			// 자원해제
			con.close();

		} catch (Exception e) {
			System.out.println("getAllCarOrder메소드 쿼리 오류 : " + e);
		}

		// 백터 리턴
		return v;
	}

	// 하나의 주문아이디를 전달받아.. 하나의 주문 정보를 리턴하는 메소드
	public Carconfirmbean getOneOrder(int orderid) {
		// 리턴할 객체를 저장할 참조변수 선언
		Carconfirmbean cbean = null;
		try {
			getCon();
			// 쿼리준비
			String sql = "select * from carorder where orderid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderid);
			// 결과 리턴 하여 rs에 저장
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cbean = new Carconfirmbean();
				cbean.setOrderid(orderid); // 예약 id
				cbean.setCarbegindate(rs.getString(5));// 대여 날짜
				cbean.setCarreserveday(rs.getInt(4));// 대여기간
				cbean.setCarins(rs.getInt(6));// 보험적용 여부
				cbean.setCarwifi(rs.getInt(7));// wifi적용 여부
				cbean.setCarnave(rs.getInt(8));// 네비 적용 여부
				cbean.setCarbabyseat(rs.getInt(9));// 베이비시트 적용 여부
			}

			con.close();

		} catch (Exception e) {

		}

		return cbean;
	}

	//예약 수정 내용을 전달받아.. 다시예약을 수정하는 메소드 
	public void carOderUpdate(CarOrderBean bean) {
		try {
			getCon();
			String sql = "update carorder set carbegindate=?, carreserveday=?, "
					+ "carqty=?, carins=?, carwifi=?, carbabyseat=? "
					+ "where orderid=? and memberpass=?";
		    //쿼리실행할 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getCarbegindate());
			pstmt.setInt(2, bean.getCarreserveday());
			pstmt.setInt(3, bean.getCarqty());
			pstmt.setInt(4, bean.getCarins());
			pstmt.setInt(5, bean.getCarwifi());
			pstmt.setInt(6, bean.getCarbabyseat());
			pstmt.setInt(7, bean.getOrderid());
			pstmt.setString(8, bean.getMemberpass());
			
			pstmt.executeUpdate();
			
			con.close();

		} catch (Exception e) {
		
			System.out.println("carOderUpdate메소드 오류 : " + e);
		}

	}//

	//하나의 주문정보를 삭제 하는 메소드 
	public int carOrderDelete(int orderid, String memberpass) {
		 int result = 0;
		try {
			getCon();
			//예약한 아이디와 사용자가입력한 패스워드에 해당하는 레코드 삭제하시오.
			String sql = "delete from carorder where orderid=? and memberpass=?";
			//?제외한 sql구문을 담은 pstmt를 반환해서 저장
			pstmt = con.prepareStatement(sql);
			//pstmt에 ?,?값 셋팅
			pstmt.setInt(1, orderid);
			pstmt.setString(2, memberpass);
			
			//delete쿼리 실행 하여  그결값 리턴 받아오는데..  delete가 성공하면 1리턴,
			//									    delete가 실패하면 0리턴
			result = pstmt.executeUpdate();
			
			//커넥션풀에 con객체 반납
			con.close();
		
		} catch (Exception e) {
			System.out.println("carOrderDelete메소드 쿼리 오류 : " + e);
		}
	
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
