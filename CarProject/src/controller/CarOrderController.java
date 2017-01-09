package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarOrderBean;

/*CarOrder.jsp���������� .. ������ ������ ������ �޴� ���� Ŭ����*/
@WebServlet("/CarOrderController.do")
public class CarOrderController extends HttpServlet {
	
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
		
		//CarOrder.jsp���������� �Ѿ�� �����͸� CarOrderBean�ڹٺ� ��ü�� ����
		CarOrderBean cbean = new CarOrderBean();
		//��Ʈ�� ���� ��ȣ �޾ƿͼ� �ڹٺ� ���� 
		cbean.setCarno(Integer.parseInt(request.getParameter("carno")));
		//��Ʈ�� ���� ����(�뿩����) �޾ƿͼ� �ڹٺ� ����
		cbean.setCarqty(Integer.parseInt(request.getParameter("carqty")));
		//�뿩�Ⱓ �޾ƿͼ� �ڹٺ� ����
		cbean.setCarreserveday(Integer.parseInt(request.getParameter("carreserveday")));
		//�ڵ��� �뿩��¥ �� �޾ƿͼ� �ڹٺ� ����
		cbean.setCarbegindate(request.getParameter("carbegindate"));
		//����� ���뿩�ΰ� �޾ƿͼ� �ڹٺ� ����
		cbean.setCarins(Integer.parseInt(request.getParameter("carins")));
		//����wifi ���뿩�ΰ� �޾ƿͼ� �ڹٺ� ����
		cbean.setCarwifi(Integer.parseInt(request.getParameter("carwifi")));
		//�׺���̼� ���뿩�ΰ� �޾ƿͼ� �ں� ����
		cbean.setCarnave(Integer.parseInt(request.getParameter("carnave")));
		//���̺��Ʈ  ���뿩�ΰ� �޾ƿͼ� �ں� ����
		cbean.setCarbabyseat(Integer.parseInt(request.getParameter("carbabyseat")));
		//��ȸ�� �Է��� ��ȭ��ȣ �޾ƿͼ� �ڹٺ� ����
		cbean.setMemberphone(request.getParameter("memberphone"));
		//��ȸ�� �Է��� �н����� �޾ƿͼ� �ڹٺ� ����
		cbean.setMemberpass(request.getParameter("memberpass"));
		
		
		//�����ͺ��̽� ��ü ����
		CarDAO cdao = new CarDAO();

		//CarDAOŬ������ ... �ֹ���Ȳ�� �����ϴ� �޼ҵ带 ������!!!!!!!
		//�޼ҵ� �̸� : insertCarOrder(CarOrderBean bean){  }
		
		//��Ʈ(�뿩)�ֹ� ��Ȳ�� DB�� �����ϴ� �޼ҵ� ȣ���!!!
		//�ڹٺ�ü �����Ͽ� insert�ϱ� <-- DB�۾�
		cdao.insertCarOrder(cbean);
		
		
		//CarList.sjp�������� �̵��ϱ�����...
		//CarListController�������� �̵��� request���� ����
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarListController.do");
		
		dis.forward(request , response);
		
	}
}
