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
import db.CarListBean;

/*��ü ���� ���� ��ư�� Ŭ�� ������... Ŭ���̾�Ʈ�� ��û�� �޴� ���� Ŭ����*/
@WebServlet("/CarListController.do")
public class CarListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		requestPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		requestPro(request, response);
	}
	//doGet,doPost ������� �����Ͱ� �Ѿ���� ��� requestPro�޼ҵ忡�� ��ûó�� 
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		/*��ü ���� �˻�*/
		//�����ͺ��̽��� �����ϱ����� Model��ü ����(CarDAO)
		CarDAO cdao = new CarDAO();
		
		//���� ������ ���̽��� �����Ͽ� �ڵ��� ������ ��� �о ���Ϳ� ����
		Vector<CarListBean>  v = cdao.getAllCarlist(); //��ü ���� �˻� �޼ҵ� ȣ�� 
		
		//CarList.jspȭ�鿡 ������ ���������� �̵���ų��.. request��ü�� ��Ƽ� ���� �ݴϴ�.
		request.setAttribute("v", v);
		
		//���� �̵�
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarList.jsp");
		
		dis.forward(request, response);
		
	}
	

}







