<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ��Ȳ�� Ȯ�� �ϴ� ������</title>
</head>
<body>
	<center>	
		<img alt="" src="img/naeyeok.jpg" border="0">
		<p><p>
		<table width="1000" border="1" align="center">
			<tr	align="center">
				<td align="center" width="150">�����̹���</td>
				<td align="center" width="100">������</td>
				<td align="center" width="100">�뿩��</td>
				<td align="center" width="50">�뿩�Ⱓ</td>
				<td align="center" width="100">�����ݾ�</td>
				<td align="center" width="70">���迩��</td>
				<td align="center" width="70">����wifi</td>
				<td align="center" width="70">�׺���̼�</td>
				<td align="center" width="70">���̺��Ʈ</td>
				<td align="center" width="100">����</td>
				<td align="center" width="100">����</td>
			</tr>
		<c:forEach var="v" items="${requestScope.v }">
			<tr align="center" height="60">
				<td align="center" width="150">
					<img alt="" src="img/${v.carimg }" width="140" height="90" border="0">
				</td>
				<td align="center" width="100">${v.carname }</td>
				<td align="center" width="100">${v.carbegindate }</td>
				<td align="center" width="50">${v.carreserveday }</td>
				<td align="center" width="100">${v.carprice }</td>
				<td align="center" width="70">
					<c:if test="${v.carins==1}">���谡��</c:if>
					<c:if test="${v.carins==0}">����̰���</c:if>
				</td>
				<td align="center" width="70">
					<c:if test="${v.carwifi==1}">�뿩</c:if>
					<c:if test="${v.carwifi==0}">�̴뿩</c:if>
				</td>
				<td align="center" width="70">
					<c:if test="${v.carnave==1}">�뿩</c:if>
					<c:if test="${v.carnave==0}">�̴뿩</c:if>
				</td>
				<td align="center" width="70">
					<c:if test="${v.carbabyseat==1}">�뿩</c:if>
					<c:if test="${v.carbabyseat==0}">�̴뿩</c:if>
				</td>				
				<td align="center" width="100">
					<button onclick="location.href='CarConfirmUpdateController.do?orderid=${v.orderid}&carimg=${v.carimg }'">
						����
					</button>
				</td>
				<td align="center" width="100">
					<!-- ��Ʈī ��������� �������ȭ��(��й�ȣ�� �Է��ϴ� ��)���� �̵��ϴµ�..�����ߴ� ���̵� ���� -->
					<button onclick="location.href='CarMain.jsp?center=CarconfirmDelete.jsp&orderid=${v.orderid}'">
						����
					</button>
				</td>
			</tr>
		</c:forEach>
		</table>
	</center>





</body>
</html>