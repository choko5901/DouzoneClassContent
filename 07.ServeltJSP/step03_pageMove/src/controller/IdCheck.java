package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerDAO;
import model.domain.Customer;


@WebServlet("/check")
public class IdCheck extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				request.getRequestDispatcher("success").forward(request, response);	
			}else {
				
				request.getRequestDispatcher("fail").forward(request, response);

			}


	}

}
