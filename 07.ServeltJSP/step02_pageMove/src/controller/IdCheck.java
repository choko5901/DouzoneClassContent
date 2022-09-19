package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/check")
public class IdCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.html -> id : it 이면 로그인 성공 -> 성공 페이지로 이동 , 실패시 실패 페이지로 이동
		String id = request.getParameter("id");
		
		if("it".equals(id)) {
			//단순 콘솔
//			System.out.println("환영합니다 : " + id + "님");
			
			//실제 화면 전달 페이지 전달
			//forward : request -> 
			
			
			// 외부에서 데이터를 들고 오는 것 뿐만 아니라 jsp에서 요청 객체에 추가로 데이터를 입력하고 싶다면
			
			request.setAttribute("server-key", "request unique key");
			
			request.getRequestDispatcher("valid").forward(request, response);
			
		}else {
			//단순 콘솔
//			System.out.println("무효한 id 입니다");
			//실제 화면 페이지 전달
			// sendRedirect
//			response.sendRedirect("invalid?id ="+id);
			response.sendRedirect("invaild.jsp");
			
			
		}
		
		
	}

}
