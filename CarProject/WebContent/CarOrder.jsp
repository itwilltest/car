<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
	<%--<�����ϱ�>�̹��� --%>
	<img alt="" src="img/haki.jpg" border="0">

	<%--�����ϱ� ��ư ��������.. ��Ʈ�ѷ� ��û��.. ��Ʈ ���� ������ ���� --%>
	<form action="CarOrderController.do" method="post">
		<p>
			<font size="13" color="blue">���� ��Ʈ��� : ��${requestScope.totalreserve }��</font>
		</p>
		<p>
			<font size="13" color="blue">���� �ɼǺ�� : ��${requestScope.totaloption }��</font>
		</p>
		<p>
			<font size="13" color="blue">�� ��� : ��${ totalreserve + totaloption }��</font>
		</p>
		<%--���� ���࿡ ���õ� �����͸� CarOrderController.java���� ���Ϸ� �Ѱ��� --%>
		<input type="hidden" name="carno" value="${requestScope.cbean.carno}">
		<input type="hidden" name="carqty" value="${requestScope.cbean.carqty}">
		<input type="hidden" name="carreserveday" value="${requestScope.cbean.carreserveday}">
		<input type="hidden" name="carins" value="${requestScope.cbean.carins}">
		<input type="hidden" name="carwifi" value="${requestScope.cbean.carwifi}">
		<input type="hidden" name="carnave" value="${requestScope.cbean.carnave}">
		<input type="hidden" name="carbabyseat" value="${requestScope.cbean.carbabyseat}">
		<input type="hidden" name="carbegindate" value="${requestScope.cbean.carbegindate}">
		
		<p>
		��ȸ�� ��ȭ��ȣ ���� : 
		<input type="text" name="memberphone" size="10">&nbsp;&nbsp;&nbsp;
		��й�ȣ : 
		<input type="password" name="memberpass" size="10">
		<input type="submit" value="�����ϱ�">
		</p>
	</form>
</center>












</body>
</html>