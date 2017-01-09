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
  CarConfirmDelete.jsp화면에서 삭제비밀번호 입력후...
  CarconfirmDeleteController로 렌트예약 삭제 작업 을 요청함
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

	// doGet,doPost 방식으로 데이터가 넘어오면 모두 requestPro메소드에서 요청처리
	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//사용자로부터 입력한 패스워드와,  주문예약한 id      전달받기
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String memberpass = request.getParameter("memberpass");
		
		//데이터 베이스 객체 생성
		CarDAO cdao = new CarDAO();
		
		int result = cdao.carOrderDelete(orderid,memberpass);
		
		if(result != 0){//delete쿼리가 제대로 실행되었다면 (삭제에 성공했다면)    1

			response.setContentType("text/html; charset=utf-8");

			PrintWriter  out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('렌트카 예약 정보를 삭제 하였습니다.');");
			out.println("location.href='CarListController.do'");
			out.println("</script>");
				
		}else {//delete쿼리가 제대로 실행되지 않았다면 -> password가 틀림    0
			
			request.setAttribute("result", result);//result 변수값은 0
			
			//실제이동
			RequestDispatcher dis = 
					request.getRequestDispatcher("CarMain.jsp?center=CarconfirmDelete.jsp");
			dis.forward(request, response);
			
		}
		
	
	}
	

}








