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
	/*�����۸�ũ ���� ����  ���ڻ� #333*/	
	#login a{text-decoration: none; color: #333}
	
	
	#login a:hover{color: #F90}
	
	/*���� ����   �ʺ� 265px  �ۿ��� 60px 0 0 40px*/
	#logo{
	float: left;
	width: 265px;
	margin: 60px 0 0 40px;
	}

</style>






</head>
<body>
	<!-- ���� �ΰ� ������ ������������ �̵��ϵ��� �ҽ��� �ۼ� -->
	<div id="logo">
		<a href="CarMain.jsp">
			<img alt="" src="img/RENT.jpg" width="300" height="80" border="0">
		</a>
	</div>
	<!-- �α��� | ȸ������ -->
	<table width="1000" height="5">
		<tr>
			<td align="right" colspan="5">
			<%
			//[�α���ó����.. session��  �̵� ���]
			//login.jsp-> MemberFrontController.java -> CarMain.jsp -> Top.jsp
			
			//���� id�� ���޹ޱ�
			String id = (String)session.getAttribute("id");
			
			//���ǰ� ����  
			if(id == null){//���ǰ��� ������ -> MemberFrontController������ �α��� | ȸ������ ó�� ��û
			%>
			<div id="login">
				<a href="./MemberLogin.me">login</a> | 
				<a href="./MemberJoin.me">join</a>	
			</div>		
			<%	
			}else {//���ǰ��� ������ -> MemberFrontController������  �α׾ƿ� | ȸ������ ó�� ��û
			%>
			<div>
				<%=id %>�� ȯ���մϴ�!  <a href="./MemberLogout.me">logout</a> | 
									 <a href="./MemberJoin.me">join</a>
			</div>	
			<%		
			}
			 %>
			</td>		
		</tr>

	</table>

	<!-- �޴� ����� -->
	<table width="1000" background="img/aa.jpg" height="5">
		<tr>
			<td align="center" bgcolor="red">
				<a href="CarMain.jsp?center=CarReservation.jsp">
					<img alt="" src="img/bb.jpg" border="0"> <!-- �����ϱ� �޴� -->
				</a>
			</td>
			<td align="center" bgcolor="red">
				<a href="CarMain.jsp?center=CarReserveConfirm.jsp">
					<img alt="" src="img/cc.jpg" border="0"> <!-- ����Ȯ�� �޴� -->
				</a>
			</td>
			<td align="center" bgcolor="red">
				<img alt="" src="img/dd.jpg" border="0"> <!-- �����Խ��� �޴� -->
			</td>
			<td align="center" bgcolor="red">
				<img alt="" src="img/even.jpg" border="0"> <!-- �̺�Ʈ �޴� -->
			</td>
			<td align="center" bgcolor="red">
				<img alt="" src="img/ee.jpg" border="0"> <!-- ������  �޴� -->
			</td>
		</tr>
	</table>
	
	
	
	






</body>
</html>








