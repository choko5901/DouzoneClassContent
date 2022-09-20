<%@page import="java.util.ArrayList, model.domain.User"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step04_EL.jsp</title>
</head>
<body>


	<h2>Java 데이터를 JSP에 전달</h2>
	
	<h3>배열 데이터 출력</h3> <br>
	
	<% 
		String[] stringArray = {"a" , "b", "c "};
		request.setAttribute("stringArray", stringArray);
	%>
	<div>${requestScope.stringArray[0]}</div> <br>
	<div>${requestScope.stringArray[1]}</div> <br>
	<div>${requestScope.stringArray[2]}</div> <br>
	<div>${requestScope.stringArray[3]}</div> <br>
	
	<h3>list 데이터 출력</h3>
	<% ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		session.setAttribute("stringList", stringList);
	%>
	<div>${sessionScope.stringList.get(1)}</div>
	<div>${sessionScope.stringList[1]}</div>
	
	
	
		
	<h3> DTO 데이터 출력</h3>
	
	<% ArrayList<User> users = new ArrayList<User>();
		users.add(new User("IT",26));
		users.add(new User("DEV",30));
		
		session.setAttribute("users", users);
		
	%>
	<!-- user들의 이름만 출력  -->
	<div>${sessionScope.users[0].getName()}</div>
	



</body>
</html>