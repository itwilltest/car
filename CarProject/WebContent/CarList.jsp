<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%--JSTL core���̺귯�� ����ϰڴ� ���� --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <center>
 	<!-- <���� ���� ����> �̹��� ���� -->
 	<img alt="" src="img/cis.jpg" border="0">
 
 <!-- ī�װ� �з� �˻��� ���Ͽ� form������ ��ûó��  -->
 <form action="CarcategoryController.do" method="post">	
 	<!-- ���� ��ü������ ���� �̹��� �ѷ��ֱ� -->
 	<table width="1000" border="0" height="470">
 		<c:set var="j" value="0"/>
		<!-- CarListController���� �Ѱܹ��� requset�����ȿ� �ִ� ���� ������ ��ŭ �ݺ� -->
		<c:forEach var="v" items="${requestScope.v}">
			<!-- 4���� �ڵ��� �̹���, ���� �ѷ��ֱ� ����.. 4������ tr�� �����ش� -->
			<c:if test="${j%4 == 0 }">
				<tr align="center">	
			</c:if>
					<td>
						<a href="CarInfoController.do?carno=${v.carno }">
							<img alt="" src="img/${v.carimg}" border="0" width="220" height="180">
						</a>
						
						<p/>
						������ : ${v.carname}<br/>
						�뿩�ݾ� : ${v.carprice}
					</td>
				<!-- j������ 1�� ���� -->
				<c:set var="j" value="${j+1}"/>	
		</c:forEach>
			  	</tr>
			  	<tr height="70">
			  		<td colspan="4" align="center">
			  			�����˻� : <select name="carcategory">
			  						<option value="Small">����</option>
			  						<option value="Mid">����</option>
			  						<option value="Big">����</option>
			  					</select>&nbsp;&nbsp;&nbsp;
			  					<input type="submit" value="�����˻�">
			  		</td>
			  	</tr>
 	</table>
 </form>
 
 
 
 
 
 
 
 
 </center>




















</body>
</html>