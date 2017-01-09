package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import db.CarDAO;
import db.CarListBean;

/*하나의 차량 이미지를 클릭했을때.. 클라이언트의 요청을 carno를  전달 받는 서블릿 클래스 입니다.*/
@WebServlet("/CarInfoController.do")
public class CarInfoController extends HttpServlet {

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
		
		//CarList.jsp에서 사용자가 선택한 자동차 번호 전달 받기
		int carno = Integer.parseInt(request.getParameter("carno"));
		
		//데이터베이스에 연결하여 하나의 자동차 정보를 읽어 드림
		CarDAO cdao = new CarDAO();
		
		//실제 데이터베이스에 접근하여 하나의 자동차 정보를 모두 읽어서..
		//하나의 컬럼정보를 저장해주는  CarListBean객체 리턴
		//단! 호출시 자동차번호를 메소드의 매개변수로 전달!!!!!!!!!!!!!!!!!!!!!!!!!
		CarListBean bean = cdao.getOneCar(carno);
		
		//리퀘스트 영역에  CarListBean객체 담기
		request.setAttribute("bean", bean);
		
		//실제 이동 
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarInfo.jsp");
		
		dis.forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}

}
