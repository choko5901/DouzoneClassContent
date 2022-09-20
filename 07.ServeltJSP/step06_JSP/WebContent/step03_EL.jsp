<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2>쿼리 스트링으로 JSP에 데이터 전달</h2>
	
	<!-- 쿼리스트링의 데이터는 JSP의 param 내장 객체 활용 
	http://localhost:8080/step06_JSP/step03_EL.jsp?name=it&age=26
	
	-->
	
	${param.name} <br>
	${param.age}
	
	




</body>
</html>