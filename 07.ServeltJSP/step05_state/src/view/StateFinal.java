package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/final")
public class StateFinal extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step01 Cookie
		//Client 시스템으로부터 Cookie 정보 획득 - 해당 서비스 제공 사이트에서 발행한 쿠키 정보에 관해서만 획득
		
		
//		Cookie[] cookies = request.getCookies();
//		
//		response.setContentType("text/html;charset=UTF-8");
//		
//		for(Cookie cookie : cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			
//						
//		}
		
		// ?? Client 시스템에 저장 되어 있는 쿠키의 값을 변경 하려면(stateData의 값을 삭제 : CookieTest -> " ")
		
//		for(int i = 0 ; i < cookies.length; i++) {
//			if(i == 1) {
//				cookies[i].setValue("");
//				response.addCookie(cookies[i]);
//			}
//		}
		
		//step02 Session
		
	
		
		
		
	}

}
