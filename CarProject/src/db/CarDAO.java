package db;
//���� �����ͺ��̽����� ��ü ���� �˻��� DB�۾�

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

	/* DB���� �޼ҵ� */
	public void getCon() {
		try {
			// 1.WAS������ ����� DBApp��������Ʈ�� ��� ������ ������ �ִ� ���ؽ�Ʈ��ü ����
			Context init = new InitialContext();

			// 2.����� WAS�������� DataSource(Ŀ�ؼ�Ǯ) �˻��ؼ� ��������
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspbeginner");

			// DataSource(Ŀ�ؼ�Ǯ)���� DB������ü (Ŀ�ؼ�) ��������
			con = ds.getConnection(); // DB����

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// getCon()�޼ҵ� ��

	// ��Ʈ �ֹ� ��Ȳ�� DB�� �����ϴ� �޼ҵ�
	public void insertCarOrder(CarOrderBean bean) {
		try {
			// Ŀ�ؼ� Ǯ���� DB���ᰴü ��������
			getCon();

			// ���� �غ� insert
			String sql = "insert into carorder(carno,carqty,carreserveday,"
					+ "carbegindate,carins,carwifi,carnave,carbabyseat,memberphone,memberpass) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";

			// ���������� pstmt��ȯ
			pstmt = con.prepareStatement(sql);
			// ?�� 10�� ����
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

			// insert���� ����
			pstmt.executeUpdate();

			// ��񿬰ᰴü �ݳ�
			con.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println("insertCarOrder�޼ҵ� ���� ���� : " + e);
			e.printStackTrace();
		}
	}// insertCarOrder�޼ҵ� ��

	/* ��ü ���� ���� �޼ҵ� �ۼ� */
	public Vector<CarListBean> getAllCarlist() {

		// CarListBean��ü�� ������ Vector��ü ����
		Vector<CarListBean> v = new Vector<CarListBean>();

		// �ϳ��� ���ڵ带 ������ ��ü�� ���� �������� ����
		CarListBean bean = null;

		try {
			// DB���� ��ü �ϳ� ���
			getCon();
			// ���� �غ� : ��ü ���� ���ڵ� �˻�
			String sql = "select * from carlist";
			// select������ �����Ҽ� �ִ� ��ü ��ȯ
			pstmt = con.prepareStatement(sql);

			// ���� ������ ����� ���� rs�� ����
			rs = pstmt.executeQuery();

			// �ݺ����� ���鼭 CarListBeanŬ������ �˻��� ������ ����
			while (rs.next()) {
				// new CarListBean()��ü ����
				bean = new CarListBean();
				// CarListBean��ü�� �˻��� ����ȣ ����
				bean.setCarno(rs.getInt(1));
				// CarListBean��ü�� �˻��� ���̸� ����
				bean.setCarname(rs.getString(2));
				// CarListBean��ü�� �˻��� �������� ����
				bean.setCarcompany(rs.getString(3));
				// CarListBean��ü�� �˻��� ������ ����
				bean.setCarprice(rs.getInt("carprice"));
				// CarListBean��ü�� �˻��� ���ν� ����
				bean.setCarusepeople(rs.getInt(5));
				// CarListBean��ü�� �˻��� ������ ����
				bean.setCarinfo(rs.getString(6));
				// CarListBean��ü�� �˻��� ���̹����� ����
				bean.setCarimg(rs.getString(7));
				// CarListBean��ü�� �˻��� ������(����,����,����) ����
				bean.setCarcategory(rs.getString(8));
				// ������� CarListBean��ü�� ���Ϳ� �߰�
				v.add(bean);

			}

		} catch (Exception e) {
			System.out.println("getAllCarlist()���� ���� ����  :" + e);
		} finally {
			// �ڿ�����
		}
		// ���� ����
		return v;
	}

	/* ī�װ��� �ڵ������ڵ� ������ �˻� �޼ҵ� */
	public Vector<CarListBean> getCategoryList(String carcategory) {
		// ������ Vector��ü ����
		Vector<CarListBean> v = new Vector<CarListBean>();
		// �ϳ��� �ڵ������ڵ带 ������ ��ü�� ���� ���� ����
		CarListBean bean = null;

		try {
			// Ŀ�ؼ� Ǯ �ȿ� �ִ� ...DB���� ��ü ��������
			getCon();

			// ���� �غ� : ī�װ��� ���� �˻�
			String sql = "select * from carlist where carcategory=?";

			// ������ �����Ҽ� �ִ� ��ü ���
			pstmt = con.prepareStatement(sql);
			// ?�� ����
			pstmt.setString(1, carcategory);
			// ���� ������ �˻� ����� ���� ResultSet�� ����
			rs = pstmt.executeQuery();

			// �ݺ����� ���鼭 CarListBeanŬ������ �˻��� ������ ����
			while (rs.next()) {
				// new CarListBean()��ü ����
				bean = new CarListBean();
				// CarListBean��ü�� �˻��� ����ȣ ����
				bean.setCarno(rs.getInt(1));
				// CarListBean��ü�� �˻��� ���̸� ����
				bean.setCarname(rs.getString(2));
				// CarListBean��ü�� �˻��� �������� ����
				bean.setCarcompany(rs.getString(3));
				// CarListBean��ü�� �˻��� ������ ����
				bean.setCarprice(rs.getInt("carprice"));
				// CarListBean��ü�� �˻��� ���ν� ����
				bean.setCarusepeople(rs.getInt(5));
				// CarListBean��ü�� �˻��� ������ ����
				bean.setCarinfo(rs.getString(6));
				// CarListBean��ü�� �˻��� ���̹����� ����
				bean.setCarimg(rs.getString(7));
				// CarListBean��ü�� �˻��� ������(����,����,����) ����
				bean.setCarcategory(rs.getString(8));
				// ������� CarListBean��ü�� ���Ϳ� �߰�
				v.add(bean);

			}

		} catch (Exception e) {
			System.out.println("getCategoryList�޼ҵ� ���� : " + e);

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

	/* �ϳ��� �ڵ��� ������ �����ϴ� �޼ҵ� */
	public CarListBean getOneCar(int carno) {
		// ������ �ϳ��� ���ڵ带 ������ CarListBean��ü�� ���� �������� ����
		CarListBean bean = null;

		try {
			// Ŀ�ؼ�Ǯ�ȿ� �ִ� DB���ᰴü ��������
			getCon();
			// ���� �غ� : �Ű������� ���޹��� ���ѹ��� �ش��ϴ� ���� ���ڵ� �˻�
			String sql = "select * from carlist where carno=?";

			// ?�� ������ ������ ���� pstmt ��ȯ
			pstmt = con.prepareStatement(sql);

			// ?�� -> ���ѹ� ����
			pstmt.setInt(1, carno);

			// ���� ������ ����� ���� rs�� ����
			rs = pstmt.executeQuery();

			// �ݺ����� ���鼭 CarListBean��ü�� �÷������͸� ����
			while (rs.next()) {
				bean = new CarListBean();
				// ����ȣ ����
				bean.setCarno(rs.getInt(1));
				// ���̸� ����
				bean.setCarname(rs.getString("carname"));
				// �������� ����
				bean.setCarcompany(rs.getString(3));
				// ������ ����
				bean.setCarprice(rs.getInt(4));
				// ���ν� ����
				bean.setCarusepeople(rs.getInt(5));
				// ������ ����
				bean.setCarinfo(rs.getString(6));
				// ���̹����� ����
				bean.setCarimg(rs.getString(7));
				// ������(����,����,����) ���ϳ� ��
				bean.setCarcategory(rs.getString(8));
			}

		} catch (Exception e) {
			System.out.println(" getOneCar �޼ҵ� ���� ���� : " + e);

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

		// CarListBean��ü ����
		return bean;
	}

	/*
	 * ����Ȯ�� ����������.. ��Ʈī ����� �ۼ���.... ��ȭ��ȣ��, �н����忡 �ش��ϴ� ������ �ֹ������� ��� �������� �޼ҵ�
	 */
	public Vector<Carconfirmbean> getAllCarOrder(String memberphone, String memberpass) {

		// ��Ʈ���� ������ ��� �ִ� ������ Carconfirmbean��ü�� ������� �÷��� ��ü ����
		Vector<Carconfirmbean> v = new Vector<Carconfirmbean>();
		// DB���� �˻��� ��Ʈ���� ������ü(CarConfirmbean��ü)�� ������ ���� ���� ����
		Carconfirmbean bean = null;

		try {
			// DB����
			getCon();

			// ��Ʈ������ ���ڰ� ���糯¥���� ũ��,
			// ��Ʈ����� �ۼ��� ��ȸ�� ��ȭ��ȣ�� �н����忡 �ش��ϴ� ��Ʈ���������� �˻��ϴµ�..
			// cororder���̺�� carlist���̺��� natural �����Ͽ� �˻�.
			String sql = "select * from carorder natural join carlist where "
					+ "now() <  str_to_date(carbegindate, '%Y-%m-%d') and " + "memberphone=? and memberpass=?";

			// ���� !! Select ���� *�Ͱ��� ������ �÷� ������ �������� ������..
			// natural ������ ������ �Ǵ� �÷����� �ٸ��÷����� ���� ��µȴ�.
			// �̶� natural ������ join�� ���� ���� �̸��� �÷��� �ߺ�������� �ʰ� �ϳ��� ����Ѵ�.

			// ?�� ������ select������ ���� Pstmt�� ��ȯ
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberphone); // ?�� ���� : ����� �ۼ��� ��ȭ��ȣ
			pstmt.setString(2, memberpass);// ?�� ���� : ����� �ۼ��� ��й�ȣ

			// select�� ��Ʈ���������� ��� �ִ� ResultSet��ü ���� �Ͽ� ����
			rs = pstmt.executeQuery();

			// ��Ʈ ���� ���� �ϳ��ϳ��� new CarConfirmBean()��ü�� ����
			while (rs.next()) {
				bean = new Carconfirmbean(); // dto��ü ����
				// �ֹ� id ���
				bean.setOrderid(rs.getInt(2));
				// ��Ʈ������ �뿩����
				bean.setCarqty(rs.getInt(3));
				// �뿩�� �Ⱓ
				bean.setCarreserveday(rs.getInt(4));
				// �ڵ����� �뿩�� ��¥
				bean.setCarbegindate(rs.getString(5));
				// �������� �ϼ� ����
				bean.setCarins(rs.getInt(6));
				// ���� wifi ���� �ϼ� ����
				bean.setCarwifi(rs.getInt(7));
				// �׺���̼� ���� �ϼ� ����
				bean.setCarnave(rs.getInt(8));
				// ���̺��Ʈ
				bean.setCarbabyseat(rs.getInt(9));
				// ��Ʈ������ �ڵ��� �̸� ����
				bean.setCarname(rs.getString(12));
				// ��Ʈ������ �ڵ��� ���� ����
				bean.setCarprice(rs.getInt(14));
				// ��Ʈ������ �ڵ��� �̹����� ����
				bean.setCarimg(rs.getString(17));

				v.add(bean); // ���Ϳ� ���

			}
			// �ڿ�����
			con.close();

		} catch (Exception e) {
			System.out.println("getAllCarOrder�޼ҵ� ���� ���� : " + e);
		}

		// ���� ����
		return v;
	}

	// �ϳ��� �ֹ����̵� ���޹޾�.. �ϳ��� �ֹ� ������ �����ϴ� �޼ҵ�
	public Carconfirmbean getOneOrder(int orderid) {
		// ������ ��ü�� ������ �������� ����
		Carconfirmbean cbean = null;
		try {
			getCon();
			// �����غ�
			String sql = "select * from carorder where orderid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderid);
			// ��� ���� �Ͽ� rs�� ����
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cbean = new Carconfirmbean();
				cbean.setOrderid(orderid); // ���� id
				cbean.setCarbegindate(rs.getString(5));// �뿩 ��¥
				cbean.setCarreserveday(rs.getInt(4));// �뿩�Ⱓ
				cbean.setCarins(rs.getInt(6));// �������� ����
				cbean.setCarwifi(rs.getInt(7));// wifi���� ����
				cbean.setCarnave(rs.getInt(8));// �׺� ���� ����
				cbean.setCarbabyseat(rs.getInt(9));// ���̺��Ʈ ���� ����
			}

			con.close();

		} catch (Exception e) {

		}

		return cbean;
	}

	//���� ���� ������ ���޹޾�.. �ٽÿ����� �����ϴ� �޼ҵ� 
	public void carOderUpdate(CarOrderBean bean) {
		try {
			getCon();
			String sql = "update carorder set carbegindate=?, carreserveday=?, "
					+ "carqty=?, carins=?, carwifi=?, carbabyseat=? "
					+ "where orderid=? and memberpass=?";
		    //���������� ��ü ����
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
		
			System.out.println("carOderUpdate�޼ҵ� ���� : " + e);
		}

	}//

	//�ϳ��� �ֹ������� ���� �ϴ� �޼ҵ� 
	public int carOrderDelete(int orderid, String memberpass) {
		 int result = 0;
		try {
			getCon();
			//������ ���̵�� ����ڰ��Է��� �н����忡 �ش��ϴ� ���ڵ� �����Ͻÿ�.
			String sql = "delete from carorder where orderid=? and memberpass=?";
			//?������ sql������ ���� pstmt�� ��ȯ�ؼ� ����
			pstmt = con.prepareStatement(sql);
			//pstmt�� ?,?�� ����
			pstmt.setInt(1, orderid);
			pstmt.setString(2, memberpass);
			
			//delete���� ���� �Ͽ�  �װᰪ ���� �޾ƿ��µ�..  delete�� �����ϸ� 1����,
			//									    delete�� �����ϸ� 0����
			result = pstmt.executeUpdate();
			
			//Ŀ�ؼ�Ǯ�� con��ü �ݳ�
			con.close();
		
		} catch (Exception e) {
			System.out.println("carOrderDelete�޼ҵ� ���� ���� : " + e);
		}
	
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
