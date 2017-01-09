package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.PStmtKey;

public class MemberDAO {

	// 디비 연결 메소드
	private Connection getConnection() throws Exception {

		Connection con = null;

		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspbeginner");
		con = ds.getConnection();

		return con;
	}

	// 회워가입 메소드
	public boolean insertMember(MemberBean mb) {

		// DB작업 삼총사 객체를 담을 변수 2개 선언
		PreparedStatement pstmt = null;
		Connection con = null;

		// 회원가입 성공여부 값을 담을 result변수 선언
		int result = 0;

		String sql = "";

		try {
			// DB연결
			con = getConnection();

			// insert SQL만들기
			sql = "insert into member2(id,pass,name,age,date,email,address,phone,mobile) "
					+ "values(?,?,?,?,?,?,?,?,?)";

			// ?를 제외한 insert구문을 담은 pstmt반환
			pstmt = con.prepareStatement(sql);
			// ??????????값 셋팅
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPass());
			pstmt.setString(3, mb.getName());
			pstmt.setInt(4, mb.getAge());
			pstmt.setTimestamp(5, mb.getDate());
			pstmt.setString(6, mb.getEmail());
			pstmt.setString(7, mb.getAddress());
			pstmt.setString(8, mb.getPhone());
			pstmt.setString(9, mb.getMobile());

			// pstmt로 insert실행 !!
			// result변수에 저장 <--회원가입에 성공하면!! 1리턴 , 실패하면!! 0 리턴
			result = pstmt.executeUpdate();

			// 만약 회원가입에 성공하면.. true리턴하세요!!
			if (result != 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("insertMember메소드 쿼리 오류 : " + e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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
		return false; // 회원가입 실패시!! false리턴
	}

	/* 로그인 처리시.. 사용하는 메소드 */
	public int userCheck(String id, String pass) {

		Connection con = null;
		String sql = "";
		PreparedStatement pstmt = null;

		int check = -1; // 1-> 아이디, 비밀번호 맞음
						// 0-> 아이디맞음, 비밀번호 틀림
						// -1 -> 아이디 틀림

		ResultSet rs = null;

		try {
			// 커넥션풀안에 있는 DB연결 객체 빌려와서 con에 담기
			con = getConnection();

			// sql ->id에 해당하는 passwd가져오기 select
			sql = "select pass from member2 where id=?";

			// 쿼리를 실행할 객체 pstmt얻기
			pstmt = con.prepareStatement(sql);

			// id에 해당하는 ?값 셋팅
			pstmt.setString(1, id);

			// rs = select실행결과 담기
			rs = pstmt.executeQuery();

			// 만약 rs 첫번째행 이동하여.. id에 해당하는 pass가 있으면......
			if (rs.next()) {
				// 만약 로그인 시 입력한 pass과 DB에 저장되어 있는 pass 같으면...???\
				if (pass.equals(rs.getString("pass"))) {
					
					check = 1; // 아이디 맞음, 비밀번호 맏음 판별값 저장
					
				// 만약 로그인 시 입력한 pass과 DB에 저장되어 있는 pass 다르면...???\
				} else {
					
					check = 0;//아이디 맙음, 비밀번호 틀림 판별값 저장
				}
			// 만약 rs 첫번째행 이동하여.. id에 해당하는 pass가 없으면.....(아이디가 없다는 뜻과 같음)
			} else {
				check = -1;// 아이디 없음 판별값 저장
			}

		} catch (Exception e) {
			System.out.println("userCheck메소드 쿼리오류 : " + e);

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return check;
	}

}
