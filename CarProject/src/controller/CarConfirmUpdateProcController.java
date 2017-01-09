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

/*차량 주문 수정페이지 CarConfirmUpdate.jsp에서....
 *차량 예약주문을 다시 수정한 내용을 전달받아 수정처리하는 서블릿 
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

	// doGet,doPost 방식으로 데이터가 넘어오면 모두 requestPro메소드에서 요청처리
	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		/*carorderbean객체를 이용하여  데이터를 저장한 후  이빈객체를  DAO로 넘겨줌*/
		CarOrderBean bean = new CarOrderBean();
		//차량 주문 수정페이지 CarConfirmUpdate.jsp에서 사용자로부터 넘어온 데이터 받아서 
		//carorderbean객체에  각각 저장 
		bean.setOrderid(Integer.parseInt(request.getParameter("orderid")));
		bean.setCarreserveday(Integer.parseInt(request.getParameter("carreserveday")));
		bean.setCarqty(Integer.parseInt(request.getParameter("carqty")));
		bean.setCarins(Integer.parseInt(request.getParameter("carins")));
		bean.setCarwifi(Integer.parseInt(request.getParameter("carwifi")));      
		bean.setCarbabyseat(Integer.parseInt(request.getParameter("carbabyseat")));
		bean.setCarbegindate(request.getParameter("carbegindate"));
		bean.setMemberpass(request.getParameter("memberpass"));
		
		//데이터베이스 객체 생성 ( CarDAO )
		CarDAO cdao = new CarDAO();
		
		//CarDAO클래스의 carOrderUpdate(CarOrderBean bean)메소드 호출시... 
		//carorderbean객체전달! 하여 수정!!!!!! 먼저할일!!-->  carOrderUpdate메소드 만들기 
		cdao.carOderUpdate(bean); 
		
		
		//수정에 성공하면.. 다시 CarList.jsp 중앙화면이 나오게 ....
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarListController.do");
		
		dis.forward(request, response);
			
	}
}
