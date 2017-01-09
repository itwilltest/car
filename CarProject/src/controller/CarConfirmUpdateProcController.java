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

/*���� �ֹ� ���������� CarConfirmUpdate.jsp����....
 *���� �����ֹ��� �ٽ� ������ ������ ���޹޾� ����ó���ϴ� ���� 
 */
@WebServlet("/CarConfirmUpdateProcController.do")
public class CarConfirmUpdateProcController extends HttpServlet {
	
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
		
		/*carorderbean��ü�� �̿��Ͽ�  �����͸� ������ ��  �̺�ü��  DAO�� �Ѱ���*/
		CarOrderBean bean = new CarOrderBean();
		//���� �ֹ� ���������� CarConfirmUpdate.jsp���� ����ڷκ��� �Ѿ�� ������ �޾Ƽ� 
		//carorderbean��ü��  ���� ���� 
		bean.setOrderid(Integer.parseInt(request.getParameter("orderid")));
		bean.setCarreserveday(Integer.parseInt(request.getParameter("carreserveday")));
		bean.setCarqty(Integer.parseInt(request.getParameter("carqty")));
		bean.setCarins(Integer.parseInt(request.getParameter("carins")));
		bean.setCarwifi(Integer.parseInt(request.getParameter("carwifi")));      
		bean.setCarbabyseat(Integer.parseInt(request.getParameter("carbabyseat")));
		bean.setCarbegindate(request.getParameter("carbegindate"));
		bean.setMemberpass(request.getParameter("memberpass"));
		
		//�����ͺ��̽� ��ü ���� ( CarDAO )
		CarDAO cdao = new CarDAO();
		
		//CarDAOŬ������ carOrderUpdate(CarOrderBean bean)�޼ҵ� ȣ���... 
		//carorderbean��ü����! �Ͽ� ����!!!!!! ��������!!-->  carOrderUpdate�޼ҵ� ����� 
		cdao.carOderUpdate(bean); 
		
		
		//������ �����ϸ�.. �ٽ� CarList.jsp �߾�ȭ���� ������ ....
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarListController.do");
		
		dis.forward(request, response);
			
	}
}
