<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>예약 현황을 확인 하는 페이지</title>
</head>
<body>
	<center>	
		<img alt="" src="img/naeyeok.jpg" border="0">
		<p><p>
		<table width="1000" border="1" align="center">
			<tr	align="center">
				<td align="center" width="150">차량이미지</td>
				<td align="center" width="100">차량명</td>
				<td align="center" width="100">대여일</td>
				<td align="center" width="50">대여기간</td>
				<td align="center" width="100">차량금액</td>
				<td align="center" width="70">보험여부</td>
				<td align="center" width="70">무선wifi</td>
				<td align="center" width="70">네비게이션</td>
				<td align="center" width="70">베이비시트</td>
				<td align="center" width="100">수정</td>
				<td align="center" width="100">삭제</td>
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
					<c:if test="${v.carins==1}">보험가입</c:if>
					<c:if test="${v.carins==0}">보험미가입</c:if>
				</td>
				<td align="center" width="70">
					<c:if test="${v.carwifi==1}">대여</c:if>
					<c:if test="${v.carwifi==0}">미대여</c:if>
				</td>
				<td align="center" width="70">
					<c:if test="${v.carnave==1}">대여</c:if>
					<c:if test="${v.carnave==0}">미대여</c:if>
				</td>
				<td align="center" width="70">
					<c:if test="${v.carbabyseat==1}">대여</c:if>
					<c:if test="${v.carbabyseat==0}">미대여</c:if>
				</td>				
				<td align="center" width="100">
					<button onclick="location.href='CarConfirmUpdateController.do?orderid=${v.orderid}&carimg=${v.carimg }'">
						수정
					</button>
				</td>
				<td align="center" width="100">
					<!-- 렌트카 예약삭제시 예약삭제화면(비밀번호를 입력하는 곳)으로 이동하는데..예약했던 아이디 전달 -->
					<button onclick="location.href='CarMain.jsp?center=CarconfirmDelete.jsp&orderid=${v.orderid}'">
						삭제
					</button>
				</td>
			</tr>
		</c:forEach>
		</table>
	</center>





</body>
</html>