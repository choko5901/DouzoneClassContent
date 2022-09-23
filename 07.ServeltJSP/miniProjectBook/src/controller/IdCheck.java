package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BkService;

@WebServlet("/check")
public class IdCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 인코딩 필터 필요
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		System.out.println(id);
//		System.out.println(pw);
		
		BkService.test(id, pw);
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
		// 로그인 버튼 (header.jsp)
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
