package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//�α׾ƿ� ��û�� ��������...
//���ǰ� �ʱ�ȭ��~~  �α׾ƿ� �޼���â�� ����ְ�..
//CarMain.jsp�������� �̵��ϴ� ���� �ϴ� ActionŬ���� 
public class MemberLogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//���ǿ����� �ִ� ����id�� �ʱ�ȭ
		HttpSession session = request.getSession(true);
		session.invalidate();
	/*	
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./Main.me");
		
		return forward;
	*/	
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('�α׾ƿ�');");
		out.println("location.href='./Main.me';");
		out.println("</script>");
		out.close();
		return null;	
	}


}
