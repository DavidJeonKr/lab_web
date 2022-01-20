package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.jsp07.service.UserService;
import edu.web.jsp07.service.UserServiceImpl;

@WebServlet(name = "signInServlet", urlPatterns = { "/signin" })
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: post에서 받아온 값
		request.setCharacterEncoding("UTF-8");
		// 클라이언트가 보내준 요청 파라미터를 분석
		String id = request.getParameter("userId");
		String pw = request.getParameter("pwd");
		
		
		
		//아이디, 비밀번호가 일치하는 사용자 계정이 있는 지 체크
		Boolean result = userService.checkSignIn(id, pw);
		if(result) { // 일치하는 사용자가 있는 경우 -> 로그인 성공
			HttpSession session = request.getSession(); // 해당 요청의 Session 객체를 찾음
			session.setAttribute("userId", id); // 세션 객체에 사용자 아이디를 저장,
			
			// 메인 페이지로 이동
			response.sendRedirect("main");
		} else { // 일치하는 사용자가 없는 경우 -> 로그인 실패
			response.sendRedirect("signin");
		}
		
		
		
	}
}
