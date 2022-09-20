package variable;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/var")
public class VariableTest extends HttpServlet {
	int num = 0;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시나리오 2명의 User가 현재의 서비스에 접속
		// 서비스 :  유저이름과 : 1부터 ~ 10 까지 출력
		// user정보는 쿼리 스트링으로 전달 ? user = user1, user = user2, .....
		
//		String env = this.getInitParameter("charset");
//		request.setCharacterEncoding(env);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("user");
		
		while (num++ <10) {
			out.print(user + " : "+ num + "<br/>");
			out.flush();
			System.out.println(num);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
