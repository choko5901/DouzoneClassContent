package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerDAO;
import model.domain.Customer;


@WebServlet("/check")
public class IdCheck extends HttpServlet {
		private static CustomerDAO customerDAO = CustomerDAO.getInstance();
		
		String value;
		
//		@Override
//		public void init(ServletConfig config) {
//			System.out.println("check : init()");
//			String value = config.getInitParameter("testParameter");
//			System.out.println(value);
//			
//		}
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(value);
		
		//여기서 this 는 서블릿 자체를 말하며 이 객체가 context를 담고 있어 getinit 메소드 사용가능
		
//		String env = this.getInitParameter("charset");
//		request.setCharacterEncoding(env);
		
		
		// 시나리오 
		/* 
		 * 1) add.html (회원가입)
		 * 	- form - input : id, pw, grade, - input : submit 가입
		 * 2) /check (회원 검증)
		 * 	- 입력된 아이디가 가상의 db 존재한다면! -> 회원 가입 실패 : fail(Servlet)
		 * 		- "회원 가입 실패 : 동일한 id 존재"
		 * 	- 입력된 아이디가 가상의 db 존재하지 않는다면! -> 회원 가입 성공 : success(Servlet)
		 * 		- "{getAttribute("company") -> "IT" } 회원 가입 성공 : {입력한 id}"
		 */
		
		

	String id = request.getParameter("id");
		
		ArrayList<Customer> list = CustomerDAO.getUserData();
		
		boolean isExist = true;
		
		for (Customer c : list) {
			if((c.getId()).equals(id)) {
				isExist= false;
			}
		}
		
		
			if(isExist) {
				request.setAttribute("compay", "IT");
//				request.getRequestDispatcher("success").forward(request, response);	
				response.sendRedirect("sucess.jsp");
				// redirect 로 뿌려 주면 파라미터값을 전달하는게 불편해서 그냥 forward방식으로 전달하는게 편함
				// 그리고 response(sucess)만 doGet이면 전달 가능하다
				
			}else { 
				
//				request.getRequestDispatcher("fail").forward(request, response);
				response.sendRedirect("fail.jsp");

			}


	}

}
