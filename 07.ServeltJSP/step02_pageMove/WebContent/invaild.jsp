<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>invaild.jsp</title>
</head>
<body>

	<h2>무효한 id를 입력하셨습니다.</h2>
	<% out.println("무효한 id를 입력하셨습니다.(java)"); %>
	<% out.println(request.getParameter("id")); %>
	
	
	

</body>
</html>