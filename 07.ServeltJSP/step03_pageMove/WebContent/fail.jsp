<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fail.jsp</title>
</head>
<body>

	<h2>회원가입 실패</h2>
	<% out.println("존재한 id를 입력하셨습니다."); %>
	<% out.println(request.getParameter("id")); %>
	
</body>
</html>