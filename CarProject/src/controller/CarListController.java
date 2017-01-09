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
import db.CarListBean;

/*전체 차량 보기 버튼을 클릭 했을때... 클라이언트의 요청을 받는 서블릿 클래스*/
@WebServlet("/CarListController.do")
public class CarListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		requestPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		requestPro(request, response);
	}
	//doGet,doPost 방식으로 데이터가 넘어오면 모두 requestPro메소드에서 요청처리 
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		/*전체 차량 검색*/
		//데이터베이스에 접근하기위한 Model객체 생성(CarDAO)
		CarDAO cdao = new CarDAO();
		
		//실제 데이터 베이스에 접근하여 자동차 정보를 모두 읽어서 백터에 저장
		Vector<CarListBean>  v = cdao.getAllCarlist(); //전체 차량 검색 메소드 호출 
		
		//CarList.jsp화면에 보여질 뷰페이지로 이동시킬떄.. request객체에 담아서 보내 줍니다.
		request.setAttribute("v", v);
		
		//실제 이동
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarList.jsp");
		
		dis.forward(request, response);
		
	}
	

}







