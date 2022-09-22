<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!-- JSTL Tag를 사용하기 위한 필수 설정 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL</h2>
	
	<h3>step01 : Condition</h3>
	<c:if test="${'a' == 'a'}" >
		조건이 참이라면 실행되는 영역
	</c:if>
	<br><hr><br>

	<!-- empty 활용하여 null 검증하기  --> 
	<% request.setAttribute("custmer", null); %>
	
	<c:if test="${empty requestScope.customer}">
	null 일떄에만 실행 영역
	</c:if>
	
	<br><hr><br>
	<!-- 다중조건 : choose, when -->
	
	<% session.setAttribute("goal", 4); %>
	
	<c:choose>
		<c:when test="${sessionScope.goal < 2}">
			헤트트릭이 아님
		</c:when>
		<c:when test="${sessionScope.goal == 3}">
			헤트트릭!
		</c:when>
		<c:otherwise>
		  해당 조건이 없을때 실행 되는 영역
		</c:otherwise>
	</c:choose>
		<br><hr><br>
	
	


</body>
</html>