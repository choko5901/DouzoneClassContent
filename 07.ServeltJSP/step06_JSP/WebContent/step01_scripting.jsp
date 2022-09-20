<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step01_scripting</title>
</head>
<body>



		<h2>Scripting</h2>
		<!-- 선언자 -->
		<%! String name = "IT";  // 맴버 변수로 사용 %!이니
		%>
		
		<h3>step01: scripting tag 학습</h3>
		<%= name %> <br>
		<% out.println(name);%>
		
		<% String name = "DEV";  // !없기떄문에 로컬 변수로 사용
		%>
		<%= name %> <br>
		
		
		<h3>step02 : EL 단순 연산</h3>
		
		${2+3} <br>
		${2>3} <br>
		${'a' == 'a'} <br>
		${'a' != 'a'} <br>
		
		<h3>step03 : EL JAVA 데이터 출력</h3>
		
		<%
		// 요청 객체
		request.setAttribute("requestData", "data");	
		
		//세선 객체
		session.setAttribute("session", "data2");
		
		//pageContext 이페이지 에서만 전달 가능한 것
		pageContext.setAttribute("pageData", "data3");
		%>
		
		1. 요청 객체 데이터 출력: 
		<!-- 리퀘스트에서 저장된 데이터에 접근 하려면 반드시 requestScope로 접근해야함 -->
		${requestScope.requestData} 
		<br>
		2. 세션 객체 데이터 출력 :
		${sessionScope.session}
		<br>
		3. 페이지 객체 데이터 출력 : ${pageScope.pageData}
		 
		
		
		
		
		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		
<br>		

</body>
</html>