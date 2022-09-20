package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManagerDAO;


@WebServlet("/check")
public class IdCheck extends HttpServlet {
	
	// 싱글톤 패턴은 class 내부에서 생성
	private static ManagerDAO managerDAO = ManagerDAO.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String dept = request.getParameter("dept");
		
		//로그인(특정 정보 존재 하는지 판단)
		HttpSession session1 = request.getSession();
		
		
		session1.setAttribute("sessionId", id);
		session1.setAttribute("sessionPw", pw);
		session1.setAttribute("sessionDept", dept);
		
		response.sendRedirect("service");
		
		
	}

}
