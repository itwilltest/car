package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.FpUtils;

public class MemberFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �����û �ּҰ� ��������
		// /CarProject/MemberJoin.me ���
		// /CarProject/MemberJoinAction.me ���
		String RequestURI = req.getRequestURI();

		// /CarProject ��� //����11
		String contextPath = req.getContextPath();

		System.out.println(contextPath.length()); // 11

		// /MemberJoin.me ���
		// /MemberJoinAction.me ���
		// /MemberLogin.me ���
		// /MemberLoginAction.me ���
		String command = RequestURI.substring(contextPath.length());

		// ������ �̵���� ���ΰ�, �̵������� ��� ���尪 �����Ͽ� ���� ���ִ� ��ü�� ������ �������� ����
		ActionForward forward = null;

		Action action = null;

		// Top.jsp���� join��ũ�� ������ ȸ�������������� �̵��ϴ� ��û�� ��� ������...
		if (command.equals("/MemberJoin.me")) {
			// ������ �̵���� ���ΰ�, �̵������� ��� ���尪 �����Ͽ� ���� ���ִ� ��ü ����
			forward = new ActionForward();
			// ������ �̵� ��� ���ΰ� false�� ���� -> RequestDispather forward()���
			forward.setRedirect(false);
			// �̵��� ������ ���(ȸ������ ������)�ּҰ� ����
			forward.setPath("./CarMain.jsp?center=member/join.jsp");

			// join.jsp���� ȸ������ ó����û�� ��� ������...
		} else if (command.equals("/MemberJoinAction.me")) {

			// ȸ������ ó���� ���� Action��ü����
			action = new MemberJoinAction();

			try {
				// join.jsp���� �Է��� ȸ������ ������ ��� �ִ�..request������ ...
				// execute�޼ҵ��� ���ڷ� �����Ͽ�...
				// ȸ������ DB�۾��� ȸ�����Կ� �����ϸ�....
				// �������̵����ΰ� true��...
				// �̵��� ������ �ּ�(/MemberLogin.me)��� �ִ�.....
				// new ActionForward��ü ���� �޾� ������.
				forward = action.execute(req, resp);

			} catch (Exception e) {

				e.printStackTrace();
			}

		} else if (command.equals("/MemberLogin.me")) {
			// ������ �̵����ΰ�, �̵������� ��� �� �����Ͽ� �������ִ� ��ü ����
			forward = new ActionForward();

			forward.setRedirect(false);// �ּ� �� ���� ���� -> forward()���

			forward.setPath("./CarMain.jsp?center=member/login.jsp");

			// login.jsp����.. "Sign in" ��ư�� ��������.. �α��� ó�� ��û �ޱ�!!!
			// ����ڰ� �Է��� id, pass�� requset������ ��� ����
		} else if (command.equals("/MemberLoginAction.me")) {
			// MemberLoginAction Ŭ���� �����

			// �α��� ó���� ���� Action��ü ����
			action = new MemberLoginAction();

			try {
				// login.jsp���� ����ڰ� �Է��� id�� �н����带 ��� �ִ� request������...
				// execute(req, resp)�޼ҵ��� �Ű������� �����Ͽ�...
				// DB�� �ִ� id�� pass���� ���Ѵ�.
				// ���࿡ ��ġ�ҋ�...
				// login.jsp���� ����ڰ� �Է��� id���� ���ǰ�ü������ �����ϰ�...
				// ������ �̵� ���ΰ���, �̵��� ������ �ּ�(Main.me)�� ��� �ִ�..
				// new ActionForward()��ü�� ���� �޾Ƽ� �����Ѵ�.
				forward = action.execute(req, resp);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// "CarMain.jsp"���������� ��û�� ��� ������...
		} else if (command.equals("/Main.me")) {
			// ������ �̵� ���ΰ�, �̵���������� �� �����Ͽ� �������ִ� ��ü ����
			forward = new ActionForward();
			forward.setRedirect(false); // �ּҰ� ���� x
			forward.setPath("./CarMain.jsp"); // �̵��� ������ ����

			// top.jsp���� logout��ũ�� Ŭ���Ͽ� ���ǰ� �ʱ�ȭ �ϰ�...
			// CarMain.jspȭ������ �̵��϶��� ��û�� ��������.............
		} else if (command.equals("/MemberLogout.me")) {

			// �α׾ƿ� ó���� ���� Action��ü ����
			action = new MemberLogoutAction();

			try {
				forward = action.execute(req, resp); // return = null;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		
//--------------------------------------------------------------------------------
		// �ּ� �̵�
		if (forward != null) {// new ActionForward()��ü�� ���� �ϰ�...

			if (forward.isRedirect()) { // true -> Response.sendRedirect()
										// ����ϋ�....

				resp.sendRedirect(forward.getPath());

			} else {// false -> forward()����ϋ�....

				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());

				dispatcher.forward(req, resp);
			} // if~ else ��

		} // if��

	}

}
