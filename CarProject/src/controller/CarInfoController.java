package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import db.CarDAO;
import db.CarListBean;

/*�ϳ��� ���� �̹����� Ŭ��������.. Ŭ���̾�Ʈ�� ��û�� carno��  ���� �޴� ���� Ŭ���� �Դϴ�.*/
@WebServlet("/CarInfoController.do")
public class CarInfoController extends HttpServlet {

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
		
		//CarList.jsp���� ����ڰ� ������ �ڵ��� ��ȣ ���� �ޱ�
		int carno = Integer.parseInt(request.getParameter("carno"));
		
		//�����ͺ��̽��� �����Ͽ� �ϳ��� �ڵ��� ������ �о� �帲
		CarDAO cdao = new CarDAO();
		
		//���� �����ͺ��̽��� �����Ͽ� �ϳ��� �ڵ��� ������ ��� �о..
		//�ϳ��� �÷������� �������ִ�  CarListBean��ü ����
		//��! ȣ��� �ڵ�����ȣ�� �޼ҵ��� �Ű������� ����!!!!!!!!!!!!!!!!!!!!!!!!!
		CarListBean bean = cdao.getOneCar(carno);
		
		//������Ʈ ������  CarListBean��ü ���
		request.setAttribute("bean", bean);
		
		//���� �̵� 
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarInfo.jsp");
		
		dis.forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}

}
