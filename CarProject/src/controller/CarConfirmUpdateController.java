package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.Carconfirmbean;

/*CarReserveResult.jsp���������� ����� ������ �ֹ� id, ����� ������ �̹��� �̸��� ���޹޴� ����*/
@WebServlet("/CarConfirmUpdateController.do")
public class CarConfirmUpdateController extends HttpServlet {

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
		
		//Ŭ���̾�Ʈ�� ��û�� �ޱ�
		String carimg = request.getParameter("carimg");
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		
		//�����ͺ��̽� �ڹٺ� ��ü ����
		CarDAO cdao  = new CarDAO();
		//��Ʈ������ id�� �����Ͽ�.. �ϳ��� �ֹ������� ������ �޼ҵ� ȣ��
		Carconfirmbean cbean = cdao.getOneOrder(orderid);
		//���� �̹����� ��Ŭ������ �߰�
		cbean.setCarimg(carimg);
		
		
		/*request������ ���*/
		//���� �ֹ� ���� ���� �������� �����ؾ���
		//�뿩�Ⱓ, �뿩��, ��������, �������뿩��, ����wifi���뿩��,���̺��Ʈ ���뿩��,��й�ȣ����..
		//�����ϰ��ִ� CarconfirmBean��ü�� reqeust������ ���
		request.setAttribute("cbean", cbean);
		
		/*View�� ����*/
		//CarConfimUpdate.jsp������(���� �ֹ� ���� ����������)�� �̵��ϸ鼭 request���� ����
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarConfirmUpdate.jsp");
		
		dis.forward(request, response);
		
		
	}
	
	
}
