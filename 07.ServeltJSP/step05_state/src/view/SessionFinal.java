package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionFinal")
public class SessionFinal extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		out.println(session.getAttribute("sessionId") + "</br>");
		out.println(session.getAttribute("msg") + "</br>");
	
		/*
		 * 세션의 경우 서버가 계속 서비스 되는 이상 사용되지 않는다는 것을 직접으로 표현
		 * 그렇지 않으면 해당 세션 객체는 존재하게 됨
		 * 서비스의 정책상 알맞지 않으므로 직접 해당 세션 객체를 없애주어야 함!
		 * EX) 로그아웃
		 * 실습)
		 * 
		 *  로그아웃 버튼 생성 -> 로그아웃 버튼 클릭 시 , 해당 세션은 삭제 + 화면 전환(Invaildate(Servlet, "/end)") -> login.html
		 *  
		 * */
		
		
		
		
		
		out.println("<button onclick=\"location.href='end'\" >로그아웃</button>");
		

		

		
		
		
		
		
		
		
	}

}
