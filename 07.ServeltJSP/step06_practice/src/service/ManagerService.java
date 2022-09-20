package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/service")
public class ManagerService extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
//		System.out.println("check로 부터 넘어온 정보" + session.getId());
		System.out.println(session.getAttribute("sessionId"));
		System.out.println(session.getAttribute("sessionPw"));
		System.out.println(session.getAttribute("sessionDept"));
		
		response.sendRedirect("endview");
		
		
	
	}



}
