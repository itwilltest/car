package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.FpUtils;

public class MemberFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 가상요청 주소값 가져오기
		// /CarProject/MemberJoin.me 얻기
		// /CarProject/MemberJoinAction.me 얻기
		String RequestURI = req.getRequestURI();

		// /CarProject 얻기 //길이11
		String contextPath = req.getContextPath();

		System.out.println(contextPath.length()); // 11

		// /MemberJoin.me 얻기
		// /MemberJoinAction.me 얻기
		// /MemberLogin.me 얻기
		// /MemberLoginAction.me 얻기
		String command = RequestURI.substring(contextPath.length());

		// 페이지 이동방식 여부값, 이동페이지 경로 저장값 저장하여 리턴 해주는 객체를 저장할 참조변수 선언
		ActionForward forward = null;

		Action action = null;

		// Top.jsp에서 join링크를 누르면 회원가입페이지로 이동하는 요청이 들어 왔을떄...
		if (command.equals("/MemberJoin.me")) {
			// 페이지 이동방식 여부값, 이동페이지 경로 저장값 저장하여 리턴 해주는 객체 생성
			forward = new ActionForward();
			// 페이지 이동 방식 여부값 false로 저장 -> RequestDispather forward()방식
			forward.setRedirect(false);
			// 이동할 페이지 경로(회원가입 페이지)주소값 저장
			forward.setPath("./CarMain.jsp?center=member/join.jsp");

			// join.jsp에서 회원가입 처리요청이 들어 왔을떄...
		} else if (command.equals("/MemberJoinAction.me")) {

			// 회원가입 처리를 위한 Action객체생성
			action = new MemberJoinAction();

			try {
				// join.jsp에서 입력한 회워가입 내용을 담고 있는..request영역을 ...
				// execute메소드의 인자로 전달하여...
				// 회원가입 DB작업후 회원가입에 성공하면....
				// 페이지이동여부값 true와...
				// 이동할 페이지 주소(/MemberLogin.me)담고 있는.....
				// new ActionForward객체 리턴 받아 저장함.
				forward = action.execute(req, resp);

			} catch (Exception e) {

				e.printStackTrace();
			}

		} else if (command.equals("/MemberLogin.me")) {
			// 페이지 이동여부값, 이동페이지 경로 값 저장하여 리턴해주는 객체 생성
			forward = new ActionForward();

			forward.setRedirect(false);// 주소 값 노출 안함 -> forward()방식

			forward.setPath("./CarMain.jsp?center=member/login.jsp");

			// login.jsp에서.. "Sign in" 버튼을 눌렀을때.. 로그인 처리 요청 받기!!!
			// 사용자가 입력한 id, pass를 requset영역에 담아 오기
		} else if (command.equals("/MemberLoginAction.me")) {
			// MemberLoginAction 클래스 만들기

			// 로그인 처리를 위한 Action객체 생성
			action = new MemberLoginAction();

			try {
				// login.jsp에서 사용자가 입력한 id와 패스워드를 담고 있는 request영역을...
				// execute(req, resp)메소드의 매개변수로 전달하여...
				// DB에 있는 id와 pass값을 비교한다.
				// 만약에 일치할떄...
				// login.jsp에서 사용자가 입력한 id값을 세션객체영역에 저장하고...
				// 페이지 이동 여부값과, 이동할 페이지 주소(Main.me)를 담고 있는..
				// new ActionForward()객체를 리턴 받아서 저장한다.
				forward = action.execute(req, resp);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// "CarMain.jsp"메인페이지 요청이 들어 왔을때...
		} else if (command.equals("/Main.me")) {
			// 페이지 이동 여부값, 이동페이지경로 값 저장하여 리턴해주는 객체 생성
			forward = new ActionForward();
			forward.setRedirect(false); // 주소값 노출 x
			forward.setPath("./CarMain.jsp"); // 이동할 페이지 저장

			// top.jsp에서 logout링크를 클릭하여 세션값 초기화 하고...
			// CarMain.jsp화면으로 이동하라라는 요청이 들어왔을때.............
		} else if (command.equals("/MemberLogout.me")) {

			// 로그아웃 처리를 위한 Action객체 생성
			action = new MemberLogoutAction();

			try {
				forward = action.execute(req, resp); // return = null;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		
//--------------------------------------------------------------------------------
		// 주소 이동
		if (forward != null) {// new ActionForward()객체가 존재 하고...

			if (forward.isRedirect()) { // true -> Response.sendRedirect()
										// 방식일떄....

				resp.sendRedirect(forward.getPath());

			} else {// false -> forward()방식일떄....

				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());

				dispatcher.forward(req, resp);
			} // if~ else 끝

		} // if끝

	}

}
