<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!--  jstl core�±� ����� ���� ���� -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<!-- <�ɼ� ����> �̹��� -->
	<img alt="" src="img/option.jpg" border="0">
	
	<!-- [�����ϱ�]��ư�� ��������.. ���� ��û -->
	<form action="CarOptionController.do" method="post">
		<table width="1000" border="0" align="center">
			<tr align="center">
				<td rowspan="7" width="600">
					<img alt="" src="img/${param.carimg }" width="500">
				</td>
				<td align="center" width="200">�뿩�Ⱓ</td>
				<td align="center" width="200">
					<select name="carreserveday">
						<option value="1">1��</option>
						<option value="2">2��</option>
						<option value="3">3��</option>
						<option value="4">4��</option>
						<option value="5">5��</option>
					</select>
				</td>		
			</tr>
			<tr>
				<td align="center">�뿩��</td>
				<td align="center"><input type="date" name="carbegindate"></td>
			</tr>
			<tr>
				<td align="center">��������</td>
				<td align="center">
					<select name="carins">
						<option value="1">��������(1��1����)</option>
						<option value="0">������</option>
					</select>
				</td>
			</tr>		
			<tr>
				<td align="center">���� Wifi</td>
				<td align="center">
					<select name="carwifi">
						<option value="1">����(1��1����)</option>
						<option value="0">������</option>
					</select>
				</td>
			</tr>			
			<tr>
				<td align="center">�׺���̼�</td>
				<td align="center">
					<select name="carnave">
						<option value="1">����(����)</option>
						<option value="0">������</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">���̺��Ʈ</td>
				<td align="center">
					<select name="carbabyseat">
						<option value="1">����(1��1����)</option>
						<option value="0">������</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="button" value="������Ϻ���" 
					onclick="location.href='CarListController.do'">
				</td>
				<td align="center">
					<input type="hidden" name="carno" value="${param.carno }">
					<input type="hidden" name="carqty" value="${param.carqty }">
					<input type="hidden" name="carprice" value="${param.carprice }">
				
					<input type="submit" value="�����ϱ�">
				</td>
			</tr>								
		</table>	
	</form>
	</center>
</body>
</html>