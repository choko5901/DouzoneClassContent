package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/check")
public class IdCheck extends HttpServlet {
     
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실습 : id 값만 활용
		
		/*
		 * 실습내용
		 * [controller(/check)]id -> [service(/save)]쿠키 , 세션 -> [view(/final)] 쿠키 , 세션 획득
		 * 
		 * */
		
		
		String id = request.getParameter("id");
		System.out.println(id);	
		
		//step01 Cookie
		
//		if(id != null) {
			//쿠키 객체 생성
			
//			Cookie cookie1 = new Cookie("stateId", id);
			
			//쿠키 설정: 클라이언트 시스템에 저장되는 잔존 시간
//			cookie1.setMaxAge(60*60*24*365); // 1년
			
			// 클라이언트 시스템에 저장
//			response.addCookie(cookie1);
			
//			response.sendRedirect("save");
			
//		}
		
		
		
			// step02 Session(HttpSession)
			
			// 생성 또는 이미 사용중인 session 정보 반환
			HttpSession session1 = request.getSession();
			System.out.println(session1.getId());
			
			session1.setAttribute("sessionId", id);
			session1.setAttribute("msg", "session 학습");
			
			// Redirect 했음에도 계속 트래킹 되는게 세션의 특징
			response.sendRedirect("save");
			
		
	
	}

}
