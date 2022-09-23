<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<style type="text/css">
	a{text-decoration: none; color: #000;}
	
    label {
		display: block; margin: 0 0 10px; font-size: 12px; font-weight: 700;
		line-height: 1; text-transform: uppercase; letter-spacing: .2em;
	}
    
    input {
		display: block; width: 100%; padding: 12px 20px; border: 0; border-radius: 4px;
		box-sizing: border-box; outline: none; background: rgba(0,0,0, 0.1); font-weight: 700;
	}
	
	.sign_us {font-size: 12px; letter-spacing: 0; text-transform: none;}
     
	button {
		width: 100%; padding: 12px 20px; border: 0; border-radius: 4px; background: #4285F4;
		outline: none; color: #fff; font-size: inherit; font-weight: 700; cursor: pointer;
	}
     
    
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<%--header에서 로그인 버튼 삭제 필요 --%>
	<%--header에서 로그인 버튼 삭제 필요 --%>
	<%--header에서 로그인 버튼 삭제 필요 --%>
	
	<h2>LOGIN</h2>
	
	<form action="check" method="post">
	    <label for="id" class="login_group">USERNAME</label>
	    <input type="text" id="id" name="id"  />
	    <label for="pw">PASSWORD</label>
	    <input type="text" id="pw" name="pw"  />
        
        <%-- forgot password : 가능하다면^ㅁ^ --%>
        <label class="sign_us">
        	<a href="#">Forgot Password?</a>
        	<a href="signUp.jsp">Sign Up</a>
        </label>
        
        <%-- 로그인 버튼 --%>
        <button type="submit">Log IN</button>
    
	</form>


</body>
</html>