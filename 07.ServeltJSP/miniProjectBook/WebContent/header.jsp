<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<style type="text/css">
	header {display: flex; justify-content: space-between; align-items: center; height: 70px; padding: 0 30px;}
	h1 {cursor: pointer;}
	ul {list-style: none;}
	li {font-size: 16px; font-weight: bold; cursor: pointer;}
</style>
</head>
<% String id = request.getParameter("id"); %>

<body>
	<header>
		<h1 onclick="location.href='main.jsp';">LOGO</h1>
		<ul class="link_bar">
			<%if(id == null) { %>
				<li onclick="location.href='login.jsp';">LOGIN</li>
			<% } else { %>
				<li><%= id %> 님</li>
				<li>LOGOUT</li>
			<% }%>
			
				
			
		</ul>
	</header>
</body>

</html>