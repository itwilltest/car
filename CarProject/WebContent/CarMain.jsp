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
<!-- �� 1���

//���� ������ ����ڷ� ���� ����ؼ� ������ �ٲ�� �κ��̱⿡ �ش� Center.jsp�� ������ �о�鿩�� �Ѵ�. 
 String center = request.getParameter("center");
 -->


<!-- ���� ������ ����ڷ� ���� ����ؼ� ������ �ٲ�� �κ��̱⿡ �ش� Center.jsp�� ������ �о� �鿩�� �Ѵ�. -->
<c:set var="center" value="${param.center}"  />

<!-- ó��  CarMain.jsp�������� �����ϸ� �翬��..param���� �޾ƿü� ���⿡ ���� �ֱ� -->
<c:if test="${center == null }"> <!-- �Ѱܹ��� center���� ������.. 
									    �̵��� Center.jsp�ּҸ� center������ ���� -->
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