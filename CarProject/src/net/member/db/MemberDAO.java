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

	// ��� ���� �޼ҵ�
	private Connection getConnection() throws Exception {

		Connection con = null;

		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspbeginner");
		con = ds.getConnection();

		return con;
	}

	// ȸ������ �޼ҵ�
	public boolean insertMember(MemberBean mb) {

		// DB�۾� ���ѻ� ��ü�� ���� ���� 2�� ����
		PreparedStatement pstmt = null;
		Connection con = null;

		// ȸ������ �������� ���� ���� result���� ����
		int result = 0;

		String sql = "";

		try {
			// DB����
			con = getConnection();

			// insert SQL�����
			sql = "insert into member2(id,pass,name,age,date,email,address,phone,mobile) "
					+ "values(?,?,?,?,?,?,?,?,?)";

			// ?�� ������ insert������ ���� pstmt��ȯ
			pstmt = con.prepareStatement(sql);
			// ??????????�� ����
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPass());
			pstmt.setString(3, mb.getName());
			pstmt.setInt(4, mb.getAge());
			pstmt.setTimestamp(5, mb.getDate());
			pstmt.setString(6, mb.getEmail());
			pstmt.setString(7, mb.getAddress());
			pstmt.setString(8, mb.getPhone());
			pstmt.setString(9, mb.getMobile());

			// pstmt�� insert���� !!
			// result������ ���� <--ȸ�����Կ� �����ϸ�!! 1���� , �����ϸ�!! 0 ����
			result = pstmt.executeUpdate();

			// ���� ȸ�����Կ� �����ϸ�.. true�����ϼ���!!
			if (result != 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("insertMember�޼ҵ� ���� ���� : " + e);
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
		return false; // ȸ������ ���н�!! false����
	}

	/* �α��� ó����.. ����ϴ� �޼ҵ� */
	public int userCheck(String id, String pass) {

		Connection con = null;
		String sql = "";
		PreparedStatement pstmt = null;

		int check = -1; // 1-> ���̵�, ��й�ȣ ����
						// 0-> ���̵����, ��й�ȣ Ʋ��
						// -1 -> ���̵� Ʋ��

		ResultSet rs = null;

		try {
			// Ŀ�ؼ�Ǯ�ȿ� �ִ� DB���� ��ü �����ͼ� con�� ���
			con = getConnection();

			// sql ->id�� �ش��ϴ� passwd�������� select
			sql = "select pass from member2 where id=?";

			// ������ ������ ��ü pstmt���
			pstmt = con.prepareStatement(sql);

			// id�� �ش��ϴ� ?�� ����
			pstmt.setString(1, id);

			// rs = select������ ���
			rs = pstmt.executeQuery();

			// ���� rs ù��°�� �̵��Ͽ�.. id�� �ش��ϴ� pass�� ������......
			if (rs.next()) {
				// ���� �α��� �� �Է��� pass�� DB�� ����Ǿ� �ִ� pass ������...???\
				if (pass.equals(rs.getString("pass"))) {
					
					check = 1; // ���̵� ����, ��й�ȣ ���� �Ǻ��� ����
					
				// ���� �α��� �� �Է��� pass�� DB�� ����Ǿ� �ִ� pass �ٸ���...???\
				} else {
					
					check = 0;//���̵� ����, ��й�ȣ Ʋ�� �Ǻ��� ����
				}
			// ���� rs ù��°�� �̵��Ͽ�.. id�� �ش��ϴ� pass�� ������.....(���̵� ���ٴ� ��� ����)
			} else {
				check = -1;// ���̵� ���� �Ǻ��� ����
			}

		} catch (Exception e) {
			System.out.println("userCheck�޼ҵ� �������� : " + e);

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
