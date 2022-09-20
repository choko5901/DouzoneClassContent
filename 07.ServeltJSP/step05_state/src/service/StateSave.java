package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/save")
public class StateSave extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			
		// step01 Cookie
		// 추가 쿠키 생성 -> final(최종 획득)
		
//		Cookie addData = new Cookie("stateData", "CookieTest");
//		addData.setMaxAge(60*60*24); // 1일
//		
//		response.addCookie(addData);
//		response.sendRedirect("final");
		
		// step02 Session
		HttpSession session = request.getSession();
		System.out.println("check로 부터 넘어온 sessionId: " + session.getId());
		System.out.println(session.getAttribute("sessionId"));
		
		response.sendRedirect("sessionFinal");
	
	
	
	}

}
