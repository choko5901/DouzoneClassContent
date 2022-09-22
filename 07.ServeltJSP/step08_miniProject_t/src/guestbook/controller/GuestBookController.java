package guestbook.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.model.GuestBookBean;
import guestbook.model.GuestBookDAO;

@WebServlet("/guestbook.do")
public class GuestBookController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//	커맨드 패턴
		// 원래 기능별로 각각 CRUD등 각각의 기능에 대한 컨트롤러가 있는게 맞는데 이게 컨트롤러가 너무 많아도 구조상 문제가 발생 할 수 있따
		// 또 그래서 커맨드 패턴으로 하나의 컨트롤러로 각 기능을 뿌려주는 역할을 해주는 것이다 무조건 정답은 아니지만 장점이 분명 있따
		
		String command = request.getParameter("command");
		System.out.println(command);
		// 
		if(command == null){
			command = "list";
		}		
		
		if(command.equals("list")){
			list(request, response);
		}else if(command.equals("write")){
			write(request, response);
		}else if(command.equals("read")){
			read(request, response);
		}else if(command.equals("updateForm")){
			updateForm(request, response);
		}else if(command.equals("update")){
			update(request, response);
		}else if(command.equals("delete")){
			delete(request, response);
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strNum=request.getParameter("num");
		String password = request.getParameter("password");
		
		if(strNum == null || strNum.trim().length() == 0 ||
			password == null || password.trim().length() == 0){
			response.sendRedirect("guestbook.do");
			return;				
		}
		boolean result = false;
		try {
			result = GuestBookDAO.deleteContent(Integer.parseInt(strNum),password);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "해당 게시글 삭제 실패했습니다. 재 시도 하셔요");
		}
		if(result){
			response.sendRedirect("guestbook.do");			
			return;
		}else{
			request.setAttribute("error", "삭제하려는 게시글이 존재하지 않습니다");
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNum = request.getParameter("num");
		String title = request.getParameter("title");
		String author = request.getParameter("author");				
		String email = request.getParameter("email");				
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		
		if(strNum == null || strNum.trim().length() == 0 ||
			title == null || title.trim().length() == 0 ||
			author == null || author.trim().length() == 0 ||
			email == null || email.trim().length() == 0 ||
			content == null || content.trim().length() == 0 ||
			password == null || password.trim().length() == 0 ){
				response.sendRedirect("guestbook.do");
				return;
		}
		
		boolean result = false;
		
		try {
			result = GuestBookDAO.updateContent(new GuestBookBean(Integer.parseInt(strNum),title,author,email,content,password));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 수정 실패");
		}
		if(result){
			response.sendRedirect("guestbook.do");
			return;
		}
		request.setAttribute("error", "게시글 수정 실패");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

	private void updateForm(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException{
		String strNum = request.getParameter("num");
		
		if(strNum == null || strNum.trim().length() == 0) {
			response.sendRedirect("guestbook.do");
			return;				
		}
		String url = "error.jsp";
		GuestBookBean gContent = null;
		try {
			gContent = GuestBookDAO.getContent(Integer.parseInt(strNum), false);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "수정하고자 하는 게시글 검색 실패했습니다");
		}
		if(gContent == null){
			request.setAttribute("error", "수정하고자 하는 게시글이 존재하지 않습니다");
		}else{
			request.setAttribute("resultContent", gContent);
			url = "update.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void read(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strNum=request.getParameter("num");
		if(strNum==null || strNum.length() == 0){
			response.sendRedirect("guestbook.do");
			return;
		}
		String url = "error.jsp";
		GuestBookBean gContent = null;
		try {
			gContent = GuestBookDAO.getContent(Integer.parseInt(strNum), true);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 읽기 실패");
		}
		if(gContent == null){
			request.setAttribute("error", "해당 게시글이 존재하지 않습니다");
		}else{
			request.setAttribute("resultContent", gContent);
			url = "read.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String title=request.getParameter("title");
		String author=request.getParameter("author");				
		String email=request.getParameter("email");				
		String content=request.getParameter("content");				
		String password=request.getParameter("password");
		
		//데이터값 입력 유무만 유효성 검증
		if(title == null || title.trim().length() == 0 ||
		author == null || author.trim().length() == 0 ||
		email == null || email.trim().length() == 0 ||
		content == null || content.trim().length() == 0 ||
		password == null || password.trim().length() == 0 ){
			response.sendRedirect("write.html");
			return;//write() 메소드 종료
		}
		
		boolean result = false;
		
		try {
			result = GuestBookDAO.writeContent(new GuestBookBean(title,author,email,content,password));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 저장 시도 실패 재 시도 하세요");
		}
		
		if(result){
			response.sendRedirect("guestbook.do"); 
		}else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		try {
			request.setAttribute("list", GuestBookDAO.getAllContents());
			url = "list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "모두 보기 실패 재 실행 해 주세요");
		}	
		request.getRequestDispatcher(url).forward(request, response);
	}

}
