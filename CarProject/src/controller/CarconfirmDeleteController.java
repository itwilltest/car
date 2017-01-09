package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.PrimitiveIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;

/*
  CarConfirmDelete.jspȭ�鿡�� ������й�ȣ �Է���...
  CarconfirmDeleteController�� ��Ʈ���� ���� �۾� �� ��û��
 */
@WebServlet("/CarconfirmDeleteController.do")
public class CarconfirmDeleteController extends HttpServlet {
	

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
		
		//����ڷκ��� �Է��� �н������,  �ֹ������� id      ���޹ޱ�
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String memberpass = request.getParameter("memberpass");
		
		//������ ���̽� ��ü ����
		CarDAO cdao = new CarDAO();
		
		int result = cdao.carOrderDelete(orderid,memberpass);
		
		if(result != 0){//delete������ ����� ����Ǿ��ٸ� (������ �����ߴٸ�)    1

			response.setContentType("text/html; charset=utf-8");

			PrintWriter  out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('��Ʈī ���� ������ ���� �Ͽ����ϴ�.');");
			out.println("location.href='CarListController.do'");
			out.println("</script>");
				
		}else {//delete������ ����� ������� �ʾҴٸ� -> password�� Ʋ��    0
			
			request.setAttribute("result", result);//result �������� 0
			
			//�����̵�
			RequestDispatcher dis = 
					request.getRequestDispatcher("CarMain.jsp?center=CarconfirmDelete.jsp");
			dis.forward(request, response);
			
		}
		
	
	}
	

}








