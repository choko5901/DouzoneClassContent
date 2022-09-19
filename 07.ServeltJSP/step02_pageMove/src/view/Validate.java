package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/valid")
public class Validate extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("valid - doPost()");
		
		
		String id = request.getParameter("id");
		
		//이렇게 getAttribute로 요청 객체에 새로운 값을 넣어주는 이유는
		// 클라이언트가 요청시 클라잉너트를 구분해 주기 위한 것
		// 이 새로운 값이 없으면 해커나 불순분자로 구분 가능
		
		
		 String serverKey =(String)request.getAttribute("server-key");
		System.out.println(serverKey);
		
		PrintWriter out = response.getWriter();
		out.println("환영합니다 : " + id + "님");
			
	}

}
