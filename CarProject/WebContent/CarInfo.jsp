<%@page import="db.CarListBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here1111111</title>
</head>
<body>
	<center>
		<!-- <������������> �̹��� -->
		<img alt="" src="img/cis.jpg" border="0">
	<!-- �ڵ��� ����� �ɼ� �����ϱ� ��ư�� ��������.. �ɼǼ����������� ��û -->
	<form action="CarMain.jsp?center=CarOption.jsp" method="post">
		<table width="1000" border="0">
			<tr align="center">
				<td rowspan="6" width="600">
					<img alt="" src="img/${bean.carimg}" width="500" border="0">
				</td>
				<td align="center" width="200">�����̸�</td>
				<td align="center" width="200">${bean.carname}</td>
			</tr>
			<tr>
				<td align="center" width="200">�뿩����</td>
				<td align="center" width="200">
					<select name="carqty">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" width="200">�����з�</td>
				<td align="center" width="200">
					${requestScope.bean.carcategory }
				</td>
			</tr>
			<tr>
				<td align="center" width="200">�뿩�ݾ�</td>
				<td align="center" width="200">
					${bean.carprice }
				</td>
			</tr>
			<tr>
				<td align="center" width="200">����ȸ��</td>
				<td align="center" width="200">
					${bean.carcompany }
				</td>
			</tr>			
			<tr>
				<td align="center" width="200">
					<!-- CarList.jsp�� �̵� -->
					<input type="button" value="����" onclick="location.href='CarListController.do'">
				</td>
				<td align="center" width="200">
					<!-- �ɼ� ���� �������� ������ ����ȣ, �̹��� �̸�, ������ �ѱ�� -->
					<input type="hidden" name="carno" value="${bean.carno }">
					<input type="hidden" name="carimg" value="${bean.carimg }">
					<input type="hidden" name="carprice" value="${bean.carprice }">
					<input type="submit" value="�ɼǼ����ϱ�">
				</td>
			</tr>
		</table>
		</form>
		
		<p>
		<b>���� ���� �󼼺���</b><p>
		${bean.carinfo}
		
		
		
		
		
		
		
		
		
		
		
		
	</center>
</body>
</html>