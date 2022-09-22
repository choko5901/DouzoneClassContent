package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeptDAO;


@WebServlet("/dept")
public class DeptController extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*시나리오
		 * 화면에서 deptno 값을 전달한다 DeptController(/dept)
		 * DTO를 따로 만들게 아니라서 전달 받은 dept를 활용하여 DB에 접근한다 : DeptDAO: getDNameByDeptno(int deptno) 
		 * 만들어 준다 원래는 서비스도 만들어 줘야 하긴해 
		 * 받은 결과 객체를 화면에 전달 한다 : view.jsp (request.setAttribute("dname", dname))
		 * 만약 받은 데이터가 없다면 : failView.jsp 를 만들어 처리
		 * */
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		try {
			String dname = DeptDAO.getDNameByDeptno(deptno);
		

		if(dname != null) {
			request.setAttribute("dname", dname);

			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
		else {
			request.setAttribute("dname", "존재 하지 않는 값");

			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
		
		
		} catch (Exception e) {
			
			// 숫자외 값 입력시 fail로 던져주는건 불가 
		}	
		
		
		
//		System.out.println(request.getAttribute("dname"));
//		response.sendRedirect("view.jsp");
		
			
	}

}
