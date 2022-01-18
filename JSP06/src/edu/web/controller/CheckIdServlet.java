package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "checkIdServlet", urlPatterns = { "/checkid" })
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파라미터들의 한글 처리
		request.setCharacterEncoding("UTF-8");
		// 요청 파라미터 값을 읽음
		String userId = request.getParameter("userId");
		
		// TODO: DB 테이블에 없는 아이디인 지 체크 
		// admin, guest는 사용 불가능(invalid), 그 이외의 아이디들은 사용가능(valid)
		String resText = "";
		if(userId.equals("admin") || userId.equals("guest")) {
			resText = "invalid";
		} else {
			resText = "valid";
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(resText);
		
	}
	
}
