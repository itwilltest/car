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
	<!-- ���� ���Ǵ� ���� �̹����� ȭ�鿡 �ѷ��ְ� -->
		<table width="1000" border="0">
			<tr>
				<td align="center" width="333">
					<img alt="" src="img/lfsonata.jpg" width="280" border="0">
				</td>
				<td align="center" width="333">
					<img alt="" src="img/k5.jpg" width="280" border="0">
				</td>
				<td align="center" width="333">
					<img alt="" src="img/avante.jpg" width="280" border="0">
				</td>
			</tr>
		</table>
		
		<!-- ����,����,������ �������� ������ �˻��ؼ� ����� ȭ�鿡 ��Ÿ���� ���� �κ� -->
		<h1><img alt="" src="img/ccs.jpg" border="0"></h1> <!-- <���� ���� ����>�̹��� -->
		
		<form action="CarcategoryController.do" method="post">
			<table width="400" border="0">
				<tr align="center">
					<td width="100">��������</td>
					<td width="100" height="50">
						<select name="carcategory">
							<option value="Small">����</option>
							<option value="Mid">����</option>
							<option value="Big">����</option>
						</select>
					</td>
					<td align="center">
						<input type="submit" value="�˻�">
					</td>
					<td align="center">
						<input type="button" value="��ü�˻�" 
						 onclick="location.href='CarListController.do'">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>











