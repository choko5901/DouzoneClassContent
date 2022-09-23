<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<style type="text/css">
	body {width: 1280px; margin: 0 auto; text-align: center;}
	section {background-color: #ddd;}
	form {margin: 50px 0;}
	.main_input {width: 345px; height: 20px; padding: 3px 1px 1px 6px; line-height: 18px;}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<form action="login" name="search">
		<input name="keyword" class="main_input"/>
		<input type="submit" value="search" />
	</form>
	<section>인기 도서</section>
</body>
</html>