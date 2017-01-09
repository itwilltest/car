package net.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

//�ϴ���
//1. ȸ������ ��(join.jsp)���� �Է��� �������� MemberBean(�ڹٺ�)�� ���� ��Ű��...
//2. �����Ų MemberBean��ü�� DB�۾��� �ϱ����� DAO��ü�� �����Ͽ� ȸ������ �Ѵ�.
//3. ȸ������ ������.. �α��� �������� �̵���Ű������...
//������ �̵� ��� ���ΰ�, �̵������� ��ΰ���  new ActionForward()��ü�� �����Ͽ�...
//MemberFronController�������� ���� ���ִ� ������ ��

public class MemberJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//ȸ������ ��(join.jsp)���� �Է��� ������ �ѱ�ó��
		request.setCharacterEncoding("UTF-8");
		
		MemberBean mb = new MemberBean();
		mb.setId(request.getParameter("id")); //ȸ�� id DTO������ 
		mb.setPass(request.getParameter("pass"));//ȸ�� pass DTO�� ����
		mb.setName(request.getParameter("name"));//ȸ�� �̸�  DTO�� ����
		mb.setAddress(request.getParameter("address"));//ȸ�� �ּ�  DTO������
		mb.setEmail(request.getParameter("email")); //ȸ�� �̸��� �ּ�  DTO�� ����
		mb.setMobile(request.getParameter("mobile"));
		mb.setPhone(request.getParameter("phone"));
		mb.setDate(new Timestamp(System.currentTimeMillis()));
		
		//ȸ������ ���� ���θ� ���� ���� ����
		boolean result = false;
		
		//MemberBean��ü�� �Ű������� DAOŬ������ insertMember()�޼ҵ忡 �����Ͽ� ȸ������ó��
		MemberDAO mdao = new MemberDAO();

		//ȸ������ ������ ��� �ִ� mb��ü�� �����Ͽ�..
		//���Կ� �����ϸ� true����, �����ϸ� false����
		result = mdao.insertMember(mb);
		
		
		//ȸ������ ó���� ���� ������� null�� ��ȯ�Ѵ�.
		if(result == false){
			System.out.println("ȸ������ ����");
			return null;
		}
		
		/*ȸ������ ������... �α��� �������� �̵� ��Ų��.*/
		//������ �̵� ��� ���ΰ�,  �̵������� ��� �ּҰ� �����Ͽ� �������ִ� ��ü ����
		ActionForward forward = new ActionForward();
		//������ �̵� ��� ���ΰ� true�� ����
		//sendReditect()<-- �̹���� �̵��Ҷ� �ּ�â�� ������ �ּ� ��� ������.
		forward.setRedirect(true);
		forward.setPath("./MemberLogin.me"); // member/login.jsp �� �̵� 
		
		//������ �̵���� ���ΰ�  true��,
		//�̵��������� �ּ� member/login.jsp�� ��� �ִ� .........
		//new ActionForward() ��ü��  MemberFrontController�� ���� 
		return forward;
	}

}




