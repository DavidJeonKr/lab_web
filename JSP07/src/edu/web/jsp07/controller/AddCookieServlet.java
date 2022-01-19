package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addCookieServlet", urlPatterns = { "/add-cookie" })
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO: WAS에서 쿠키(cookie)를 생성하고, 응답(response)에 쿠키를 포함시켜서 클라이언트에게 전달하는 방법 
		// 1. Cookie 생성
		Cookie cookie1 = new Cookie("nickName", "ITWILL");
		// 2. 생성된 Cookie 객체의 설정 세팅: 만료 기간,  도메인(domain), ...
		// 3. 새성된 Cookie 객체를 응답(response) 객체에 추가.
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("age", "20");
		cookie2.setMaxAge(10); // 브라우저에서 쿠키를 저장하는 최대 시간. 단위는 초(second).
		response.addCookie(cookie2);
		
		// Servlet에서 View(JSP)로 포워드 이동
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/01_cookie_result.jsp").forward(request, response);
		
		
	}

}
