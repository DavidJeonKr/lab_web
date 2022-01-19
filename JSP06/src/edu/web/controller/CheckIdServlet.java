package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckIdServlet
 */
@WebServlet(name = "checkIdServlet", urlPatterns = { "/checkid" })
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 요청 파라미터들의 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 요청 파라미터 값을 읽음
		String userId = request.getParameter("userId");
		System.out.println("userId = " + userId);
		
		// TODO: DB 테이블에 없는 아이디인 지 체크
		// admin, guest는 사용 불가능(invalid), 그 이외의 아이디들은 사용 가능(valid) 응답.
		String resText = "";
		if (userId.equals("admin") || userId.equals("guest")) {
			resText = "invalid";
		} else {
			resText = "valid";
		}
		
		// 클라이언트로 응답 보냄
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(resText);
	}

}