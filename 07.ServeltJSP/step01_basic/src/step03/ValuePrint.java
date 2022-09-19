package step03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/value")
public class ValuePrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ValuePrint() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post 방식에서 한글 처리 
		request.setCharacterEncoding("UTF-8");

		
		
		// 요청사항항
		// webContent - view - choice.html 에서 선택한 값들을 cosole에 출력
//		String like = request.getParameter("like");
		String[] like2 = request.getParameterValues("like");
//		for (int i = 0 ; i < like2.length ; i++) {
//			System.out.println(like2[i]);
//			
//		}
//		
		// 향상된 for문 쓸떄 매개변수를 배열의 타입에 맞게 선언 해줘야한다
		for(String s : like2) {
			System.out.println(s);
		}
		
		// 한글로된 value값을 받을 때 인코딩이 꺠져서 넘어오는데 이때 
		// req 문제인지 resp 문제인지 파악 해보고
		// encoding을 해결 해봐라
		
		
	}

}
