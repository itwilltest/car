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
import db.Carconfirmbean;

/*
 CarReseveConfirm.jsp <예약확인> 페이지에서...
 렌트카 예약시  <예약확인>을 하기 위해.. 입력한  전화번호와 비밀번호를 전달받아..
 DB에 해당하는 레코드가 있는지 검사하는 서블릿 컨트롤러 클래스 
 
 */
@WebServlet("/CarReserveConfirmController.do")
public class CarReserveConfirmController extends HttpServlet {

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
		// CarReseverConfirm.jsp <예약확인> 페이지에서 사용자로부터 넘어온 전화번호,비밀번호 가져오기
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");

		// 데이터베이스 객체 생성
		CarDAO cdao = new CarDAO();

		// 예약 확인을위해..
		// 렌트예약시 입력했던 비회원 전화번호와, 패스워드를 전달하여....
		// 조건1. 전화번호와 비밀번호를 기준으로 하여 검색하여야 한다.
		// 조건2. 지금날짜보다 이전 예약 현황은 보여주지 말아라!
		// Carconfirmbean 렌트 예약 정보 객체를 담고있는 백터 객체 리턴
		Vector<Carconfirmbean> v = cdao.getAllCarOrder(memberphone, memberpass);

		// CarReserveResult.jsp(예약현황을 확인하는페이지 view)로..
		// 데이터를 넘겨주어야 하기데 request영역에 담기
		request.setAttribute("v", v);

		// 실제이동
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarReserveResult.jsp");
		dis.forward(request, response);

	}

}
