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

/*CarOrder.jsp페이지에서 .. 전달한 예약할 정보를 받는 서블릿 클래스*/
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

	// doGet,doPost 방식으로 데이터가 넘어오면 모두 requestPro메소드에서 요청처리
	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//CarOrder.jsp페이지에서 넘어온 데이터를 CarOrderBean자바빈 객체에 저장
		CarOrderBean cbean = new CarOrderBean();
		//렌트할 차량 번호 받아와서 자바빈에 저장 
		cbean.setCarno(Integer.parseInt(request.getParameter("carno")));
		//렌트할 차량 수량(대여수량) 받아와서 자바빈에 저장
		cbean.setCarqty(Integer.parseInt(request.getParameter("carqty")));
		//대여기간 받아와서 자바빈에 저장
		cbean.setCarreserveday(Integer.parseInt(request.getParameter("carreserveday")));
		//자동차 대여날짜 를 받아와서 자바빈에 저장
		cbean.setCarbegindate(request.getParameter("carbegindate"));
		//보험비 적용여부값 받아와서 자바빈에 저장
		cbean.setCarins(Integer.parseInt(request.getParameter("carins")));
		//무선wifi 적용여부값 받아와서 자바빈에 저장
		cbean.setCarwifi(Integer.parseInt(request.getParameter("carwifi")));
		//네비게이션 적용여부값 받아와서 자빈에 저장
		cbean.setCarnave(Integer.parseInt(request.getParameter("carnave")));
		//베이비시트  적용여부값 받아와서 자빈에 저장
		cbean.setCarbabyseat(Integer.parseInt(request.getParameter("carbabyseat")));
		//비회원 입력한 전화번호 받아와서 자바빈에 저장
		cbean.setMemberphone(request.getParameter("memberphone"));
		//비회원 입력한 패스워드 받아와서 자바빈에 저장
		cbean.setMemberpass(request.getParameter("memberpass"));
		
		
		//데이터베이스 객체 생성
		CarDAO cdao = new CarDAO();

		//CarDAO클래스에 ... 주문현황을 저장하는 메소드를 만들자!!!!!!!
		//메소드 이름 : insertCarOrder(CarOrderBean bean){  }
		
		//렌트(대여)주문 현황을 DB에 저장하는 메소드 호출시!!!
		//자바빈객체 전달하여 insert하기 <-- DB작업
		cdao.insertCarOrder(cbean);
		
		
		//CarList.sjp페이지로 이동하기위해...
		//CarListController서블릿으로 이동시 request영역 전달
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarListController.do");
		
		dis.forward(request , response);
		
	}
}
