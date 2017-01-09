<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%--JSTL core라이브러리 사용하겠다 선언 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <center>
 	<!-- <차량 정보 보기> 이미지 적용 -->
 	<img alt="" src="img/cis.jpg" border="0">
 
 <!-- 카테고리 분류 검색을 위하여 form데이터 요청처리  -->
 <form action="CarcategoryController.do" method="post">	
 	<!-- 실제 전체차량에 관한 이미지 뿌려주기 -->
 	<table width="1000" border="0" height="470">
 		<c:set var="j" value="0"/>
		<!-- CarListController에서 넘겨받은 requset영역안에 있는 백터 사이즈 만큼 반복 -->
		<c:forEach var="v" items="${requestScope.v}">
			<!-- 4열식 자동차 이미지, 내용 뿌려주기 위해.. 4번마다 tr을 열어준다 -->
			<c:if test="${j%4 == 0 }">
				<tr align="center">	
			</c:if>
					<td>
						<a href="CarInfoController.do?carno=${v.carno }">
							<img alt="" src="img/${v.carimg}" border="0" width="220" height="180">
						</a>
						
						<p/>
						차량명 : ${v.carname}<br/>
						대여금액 : ${v.carprice}
					</td>
				<!-- j변수값 1씩 증가 -->
				<c:set var="j" value="${j+1}"/>	
		</c:forEach>
			  	</tr>
			  	<tr height="70">
			  		<td colspan="4" align="center">
			  			차량검색 : <select name="carcategory">
			  						<option value="Small">소형</option>
			  						<option value="Mid">중형</option>
			  						<option value="Big">대형</option>
			  					</select>&nbsp;&nbsp;&nbsp;
			  					<input type="submit" value="차량검색">
			  		</td>
			  	</tr>
 	</table>
 </form>
 
 
 
 
 
 
 
 
 </center>




















</body>
</html>