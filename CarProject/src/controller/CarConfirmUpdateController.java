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

/*CarReserveResult.jsp페이지에서 예약된 차량의 주문 id, 예약된 차량의 이미지 이름을 전달받는 서블릿*/
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

	// doGet,doPost 방식으로 데이터가 넘어오면 모두 requestPro메소드에서 요청처리
	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//클라이언트의 요청값 받기
		String carimg = request.getParameter("carimg");
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		
		//데이터베이스 자바빈 객체 생성
		CarDAO cdao  = new CarDAO();
		//렌트예약한 id를 전달하여.. 하나의 주문정보를 얻어오는 메소드 호출
		Carconfirmbean cbean = cdao.getOneOrder(orderid);
		//차량 이미지를 빈클래스에 추가
		cbean.setCarimg(carimg);
		
		
		/*request영역에 담기*/
		//차량 주문 정보 수정 페이지로 전달해야함
		//대여기간, 대여일, 차량수량, 보험적용여부, 무선wifi적용여부,베이비시트 적용여부,비밀번호등을..
		//저장하고있는 CarconfirmBean객체를 reqeust영역에 담기
		request.setAttribute("cbean", cbean);
		
		/*View로 전달*/
		//CarConfimUpdate.jsp페이지(차량 주문 정보 수정페이지)로 이동하면서 request영역 전달
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarConfirmUpdate.jsp");
		
		dis.forward(request, response);
		
		
	}
	
	
}
