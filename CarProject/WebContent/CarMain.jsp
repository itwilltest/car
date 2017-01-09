<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here1</title>
</head>
<body>
<!-- 모델 1방식

//센터 공간은 사용자로 부터 계속해서 정보가 바뀌는 부분이기에 해당 Center.jsp의 정보를 읽어들여야 한다. 
 String center = request.getParameter("center");
 -->


<!-- 센터 공간은 사용자로 부터 계속해서 정보가 바뀌는 부분이기에 해당 Center.jsp의 정보를 읽어 들여야 한다. -->
<c:set var="center" value="${param.center}"  />

<!-- 처음  CarMain.jsp페이지를 실행하면 당연히..param값을 받아올수 없기에 조건 주기 -->
<c:if test="${center == null }"> <!-- 넘겨받은 center값이 없으면.. 
									    이동할 Center.jsp주소를 center변수에 저장 -->
   <c:set var="center" value="Center.jsp"/>

</c:if>

<center>
	<table width="1000" height="700">
		<tr align="center">
			<td style="">
				<jsp:include page="Top.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="500">
				<jsp:include page="${center}"/>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="Bottom.jsp"/>
			</td>
		</tr>
	</table>
</center>
</body>
</html>