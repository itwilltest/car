package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarOrderBean;

//CarOption.jsp(�ɼǼ���������)����  [�����ϱ�]��ư�� ��������... Ŭ���̾�Ʈ�� ��û�� �޴� ���� Ŭ���� 
@WebServlet("/CarOptionController.do")
public class CarOptionController extends HttpServlet {
	
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
		
		//CarOption.jsp ���� ������ �ݾ� ������ ���Ͽ� �����͸�  ������ �޾���
		int carqty = Integer.parseInt(request.getParameter("carqty")); //�뿩 ���� �ޱ�
		int carprice = Integer.parseInt(request.getParameter("carprice"));//�뿩�ݾ� �ޱ�
		int carreserveday = Integer.parseInt(request.getParameter("carreserveday"));//�뿩��¥ �ޱ�
		
		//����� ���뿩�� �ޱ�  =  �������� 1���̸� : �� 1�ޱ�
		//����� ���뿩�� �ޱ�  =  ��������� �̸� : �� 0�ޱ�
		int carins = Integer.parseInt(request.getParameter("carins"));
		
		//����wifi ���� ���� �ޱ� = ���� 1���̸� : �� 1�ޱ�
		//����wifi ���� ���� �ޱ� = �������̸� : �� 0�ޱ�
		int carwifi  = Integer.parseInt(request.getParameter("carwifi"));
		
		//�׺���̼�  ���� ���� �ޱ� = ����(����)�̸� : �� 1�ޱ�
		//�׺���̼�  ���� ���� �ޱ� = �������̸� : �� 0�ޱ�
		int carnave  = Integer.parseInt(request.getParameter("carnave"));
		
		//���̺��Ʈ ���� ���� �ޱ� = ���� 1���̸� : �� 1�ޱ�
		//���̺��Ʈ  ���� ���� �ޱ� = �������̸� : �� 0�ޱ�
		int carbabyseat  = Integer.parseInt(request.getParameter("carbabyseat"));

		
		//����!! �����Ŀ� ����� CarOrder.jsp�� �����͸� �Ѱܾ� ��
		//���� ���� = ���� * �뿩�Ⱓ * �������� 
		int totalreserve = carqty * carreserveday * carprice;
		
		//�ɼ� �ݾ� = �����ɼǿ� �뿩�Ⱓ�� ������ ���ؼ� ����
		int totaloption = 
((carins * carreserveday) + (carwifi * carreserveday) + (carbabyseat * carreserveday))
*10000 *carqty;
		
		//CarOrder.jsp�U���� �����ߴ� �����͵��� ��� �Ѱ��־����.
		//�׷��⿡ �ռ�.. 
		//���� CarOption.jsp���� ������ �����͵��� �ڹٺ�Ŭ����(CarOrderBean.java)�� ������.
		//------------> db��Ű����  CarOrderBean�ڹٺ� Ŭ���� �����
		
		//�ڹٺ�Ŭ���� CarOrderBean��ü �����Ͽ� CarOption.jsp���� ������ ������ �����ϱ�
		CarOrderBean cbean = new CarOrderBean();
		//��Ʈ�� ���� ��ȣ �޾ƿͼ� �ڹٺ� ���� 
		cbean.setCarno(Integer.parseInt(request.getParameter("carno")));
		//��Ʈ�� ���� ����(�뿩����) �޾ƿͼ� �ڹٺ� ����
		cbean.setCarqty(carqty);
		//�뿩�Ⱓ �޾ƿͼ� �ڹٺ� ����
		cbean.setCarreserveday(carreserveday);
		//����� ���뿩�ΰ� �޾ƿͼ� �ڹٺ� ����
		cbean.setCarins(carins);
		//�׺���̼� ���뿩�ΰ� �޾ƿͼ� ���ں� ����
		cbean.setCarnave(carnave);
		//���̺��Ʈ  ���뿩�ΰ� �޾ƿͼ� ���ں� ����
		cbean.setCarbabyseat(carbabyseat);
		//�ڵ��� �뿩��¥ �� �޾ƿͼ� �ڹٺ� ����
		cbean.setCarbegindate(request.getParameter("carbegindate"));
		
		
//------------------------------------------
		
		//CarOrder.jsp�� �����͸� �ѱ�� ���� request������ �����ϱ� (Ź������ �÷� ����)
		//request������ CarOrderBean��ü ���
		request.setAttribute("cbean", cbean);
		//request������ ��Ʈ(�뿩)���� ���ױݾ�  ���
		request.setAttribute("totalreserve", totalreserve);
		//request������ ��Ʈ(�뿩)���� �ɼǱݾ�  ���
		request.setAttribute("totaloption", totaloption);
		
		
//-------------------------------------------
		//���� CarOrder.jsp�� �̵��� ...request���� ����
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarOrder.jsp");
		
		dis.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
