package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarListBean;

//CarList.jsp페이지 또는 CarReservation.jsp페이지 에서  소형,중형,대형중 하나를 선택한 요청을 받았을떄..
@WebServlet("/CarcategoryController.do")
public class CarcategoryController extends HttpServlet {

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

		// CarList.jsp페이지 또는 CarReservation.jsp페이지 에서
		// 사용자가 선택한 카테고리값을 먼저 읽어 드림
		String carcategory = request.getParameter("carcategory");

		// 데이터 베이스 작업 객체 생성
		CarDAO cdao = new CarDAO();
		// 카테고리별 차량검색 메소드를 호출하여.. 검색한 레코드를 담고 있는 백터객체 리턴 받기
		// 단 호출시!! 카테고리값 메소드의 매개변수로 전달!!!!
		Vector<CarListBean> v = cdao.getCategoryList(carcategory);

		request.setAttribute("v", v);

		RequestDispatcher dis = request.getRequestDispatcher("CarMain.jsp?center=CarList.jsp");

		dis.forward(request, response);

	}
}
