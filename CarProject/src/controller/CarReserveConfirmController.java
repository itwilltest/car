package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.Carconfirmbean;

/*
 CarReseveConfirm.jsp <����Ȯ��> ����������...
 ��Ʈī �����  <����Ȯ��>�� �ϱ� ����.. �Է���  ��ȭ��ȣ�� ��й�ȣ�� ���޹޾�..
 DB�� �ش��ϴ� ���ڵ尡 �ִ��� �˻��ϴ� ���� ��Ʈ�ѷ� Ŭ���� 
 
 */
@WebServlet("/CarReserveConfirmController.do")
public class CarReserveConfirmController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	// doGet,doPost ������� �����Ͱ� �Ѿ���� ��� requestPro�޼ҵ忡�� ��ûó��
	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// CarReseverConfirm.jsp <����Ȯ��> ���������� ����ڷκ��� �Ѿ�� ��ȭ��ȣ,��й�ȣ ��������
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");

		// �����ͺ��̽� ��ü ����
		CarDAO cdao = new CarDAO();

		// ���� Ȯ��������..
		// ��Ʈ����� �Է��ߴ� ��ȸ�� ��ȭ��ȣ��, �н����带 �����Ͽ�....
		// ����1. ��ȭ��ȣ�� ��й�ȣ�� �������� �Ͽ� �˻��Ͽ��� �Ѵ�.
		// ����2. ���ݳ�¥���� ���� ���� ��Ȳ�� �������� ���ƶ�!
		// Carconfirmbean ��Ʈ ���� ���� ��ü�� ����ִ� ���� ��ü ����
		Vector<Carconfirmbean> v = cdao.getAllCarOrder(memberphone, memberpass);

		// CarReserveResult.jsp(������Ȳ�� Ȯ���ϴ������� view)��..
		// �����͸� �Ѱ��־�� �ϱⵥ request������ ���
		request.setAttribute("v", v);

		// �����̵�
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarReserveResult.jsp");
		dis.forward(request, response);

	}

}
