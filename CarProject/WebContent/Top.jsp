<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style type="text/css">
	#login{
			float: right;  
			margin: 20px 64px 0 0p;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px; word-spacing: 5px;
		}
	/*하이퍼링크 밑줄 없음  글자색 #333*/	
	#login a{text-decoration: none; color: #333}
	
	
	#login a:hover{color: #F90}
	
	/*정렬 왼쪽   너비 265px  밖여백 60px 0 0 40px*/
	#logo{
	float: left;
	width: 265px;
	margin: 60px 0 0 40px;
	}

</style>






</head>
<body>
	<!-- 메인 로고를 누르면 메인페이지로 이동하도록 소스를 작성 -->
	<div id="logo">
		<a href="CarMain.jsp">
			<img alt="" src="img/RENT.jpg" width="300" height="80" border="0">
		</a>
	</div>
	<!-- 로그인 | 회원가입 -->
	<table width="1000" height="5">
		<tr>
			<td align="right" colspan="5">
			<%
			//[로그인처리시.. session값  이동 경로]
			//login.jsp-> MemberFrontController.java -> CarMain.jsp -> Top.jsp
			
			//세션 id값 전달받기
			String id = (String)session.getAttribute("id");
			
			//세션값 없음  
			if(id == null){//세션값이 없으면 -> MemberFrontController서블릿에 로그인 | 회원가입 처리 요청
			%>
			<div id="login">
				<a href="./MemberLogin.me">login</a> | 
				<a href="./MemberJoin.me">join</a>	
			</div>		
			<%	
			}else {//세션값이 있으면 -> MemberFrontController서블릿에  로그아웃 | 회원가입 처리 요청
			%>
			<div>
				<%=id %>님 환영합니다!  <a href="./MemberLogout.me">logout</a> | 
									 <a href="./MemberJoin.me">join</a>
			</div>	
			<%		
			}
			 %>
			</td>		
		</tr>

	</table>

	<!-- 메뉴 만들기 -->
	<table width="1000" background="img/aa.jpg" height="5">
		<tr>
			<td align="center" bgcolor="red">
				<a href="CarMain.jsp?center=CarReservation.jsp">
					<img alt="" src="img/bb.jpg" border="0"> <!-- 예약하기 메뉴 -->
				</a>
			</td>
			<td align="center" bgcolor="red">
				<a href="CarMain.jsp?center=CarReserveConfirm.jsp">
					<img alt="" src="img/cc.jpg" border="0"> <!-- 예약확인 메뉴 -->
				</a>
			</td>
			<td align="center" bgcolor="red">
				<img alt="" src="img/dd.jpg" border="0"> <!-- 자유게시판 메뉴 -->
			</td>
			<td align="center" bgcolor="red">
				<img alt="" src="img/even.jpg" border="0"> <!-- 이벤트 메뉴 -->
			</td>
			<td align="center" bgcolor="red">
				<img alt="" src="img/ee.jpg" border="0"> <!-- 고객센터  메뉴 -->
			</td>
		</tr>
	</table>
	
	
	
	






</body>
</html>








