package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/end")
public class Invaildate extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 로그아웃 버튼 클릭시에만 실행하는 서블릿
		 * 
		 * 세션 무효화 - > login.html 화면 전환
		 * 
		 * */
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("sessionId"));
		
		session.invalidate();
		session =null;
		
		response.sendRedirect("login.html");

		
		
	}
	
}
