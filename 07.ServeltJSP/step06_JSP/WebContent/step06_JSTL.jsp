<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="model.domain.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step06_JSTL.jsp</title>
</head>
<body>

	<h2>JSTL</h2>
	<h3>step02 : loop</h3>
	<% ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		session.setAttribute("stringList", stringList);
	%>
	<!-- 1~5출력 해보기 -->
	<c:forEach begin="1" end="5" var="i">
		${i} <br>			
	</c:forEach>
	
	<br><hr><br>
	
	<!-- 반복의 상태 정보 출력 -->
	
	<!-- index와 count 결과는 같으나 index는 몇번째 있는 데이터를 나타내는거고 count는 단순 출력 갯수 를 뜻함  -->
	<c:forEach begin="1" end="5" var="i" varStatus="LoopStatus">
		${LoopStatus.index} <br>			
		${LoopStatus.count} <br>			
	</c:forEach>
	
	<!-- StringList를 활용한 데이터 출력 -->
	<!-- forEach items에 세션으로 받아오는 어레이리스트는 sessionScope.어레이리스트 이름 으로 받아 온다 -->
	<c:forEach items= "${sessionScope.stringList}" var="data" varStatus="LoopStatus">
	
	${LoopStatus.count} 번째 데이터 : ${data} <br>
	
	</c:forEach>
	
	<%-- model.domain.User 클래스를 활용하여 3개 이상 데이터 저장 후 개수, 이름, 나이 
			1번 데이터 - 이름: it 나이: 26
			2번 데이터 - 이름: dev 나이: 28
			3번 데이터 - 이름: server 나이: 30
	 --%>
	 
	<% ArrayList<User> users = new ArrayList<User>();
		users.add(new User("IT",26));
		users.add(new User("DEV",28));
		users.add(new User("server",30));
		
		session.setAttribute("users", users);
		
	%>
	
	<!-- ArrayList에서 특정 키에 해당하는 값 호출시 꼭 꼭 꼭 .get떙떙() 마지막 소괄호 좀 해랏 -->
	 <c:forEach items= "${sessionScope.users}" var="data" varStatus="LoopStatus">
	
	${LoopStatus.count}번째 데이터 : 이름 ${data.getName()}, 나이 ${data.getAge()} <br>
	
	</c:forEach>
	 
	 

</body>
</html>