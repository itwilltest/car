package net.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

//하는일
//1. 회원가입 폼(join.jsp)에서 입력한 정보들을 MemberBean(자바빈)에 저장 시키고...
//2. 저장시킨 MemberBean객체를 DB작업을 하기위한 DAO객체에 전달하여 회원가입 한다.
//3. 회원가입 성공시.. 로그인 페이지로 이동시키기위해...
//페이지 이동 방식 여부값, 이동페이지 경로값을  new ActionForward()객체에 저장하여...
//MemberFronController서블릿으로 리턴 해주는 역할을 함

public class MemberJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//회원가입 폼(join.jsp)에서 입력한 내용을 한글처리
		request.setCharacterEncoding("UTF-8");
		
		MemberBean mb = new MemberBean();
		mb.setId(request.getParameter("id")); //회원 id DTO에저장 
		mb.setPass(request.getParameter("pass"));//회원 pass DTO에 저장
		mb.setName(request.getParameter("name"));//회원 이름  DTO에 저장
		mb.setAddress(request.getParameter("address"));//회원 주소  DTO에저장
		mb.setEmail(request.getParameter("email")); //회원 이메일 주소  DTO에 저장
		mb.setMobile(request.getParameter("mobile"));
		mb.setPhone(request.getParameter("phone"));
		mb.setDate(new Timestamp(System.currentTimeMillis()));
		
		//회원가입 성공 여부를 담을 변수 선언
		boolean result = false;
		
		//MemberBean객체를 매개변수로 DAO클래스의 insertMember()메소드에 전달하여 회원가입처리
		MemberDAO mdao = new MemberDAO();

		//회원가입 내용을 담고 있는 mb객체를 전달하여..
		//가입에 성공하면 true리턴, 실패하면 false리턴
		result = mdao.insertMember(mb);
		
		
		//회원가입 처리에 실패 했을경우 null을 반환한다.
		if(result == false){
			System.out.println("회원가입 실패");
			return null;
		}
		
		/*회원가입 성공시... 로그인 페이지로 이동 시킨다.*/
		//페이지 이동 방식 여부값,  이동페이지 경로 주소값 저장하여 리턴해주는 객체 생성
		ActionForward forward = new ActionForward();
		//페이지 이동 방식 여부값 true로 저장
		//sendReditect()<-- 이방식은 이동할때 주소창에 페이지 주소 경로 노출함.
		forward.setRedirect(true);
		forward.setPath("./MemberLogin.me"); // member/login.jsp 로 이동 
		
		//페이지 이동방식 여부값  true와,
		//이동할페이지 주소 member/login.jsp를 담고 있는 .........
		//new ActionForward() 객체를  MemberFrontController로 리턴 
		return forward;
	}

}




