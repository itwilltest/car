package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarListBean;

//CarList.jsp������ �Ǵ� CarReservation.jsp������ ����  ����,����,������ �ϳ��� ������ ��û�� �޾�����..
@WebServlet("/CarcategoryController.do")
public class CarcategoryController extends HttpServlet {

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

		// CarList.jsp������ �Ǵ� CarReservation.jsp������ ����
		// ����ڰ� ������ ī�װ����� ���� �о� �帲
		String carcategory = request.getParameter("carcategory");

		// ������ ���̽� �۾� ��ü ����
		CarDAO cdao = new CarDAO();
		// ī�װ��� �����˻� �޼ҵ带 ȣ���Ͽ�.. �˻��� ���ڵ带 ��� �ִ� ���Ͱ�ü ���� �ޱ�
		// �� ȣ���!! ī�װ��� �޼ҵ��� �Ű������� ����!!!!
		Vector<CarListBean> v = cdao.getCategoryList(carcategory);

		request.setAttribute("v", v);

		RequestDispatcher dis = request.getRequestDispatcher("CarMain.jsp?center=CarList.jsp");

		dis.forward(request, response);

	}
}
