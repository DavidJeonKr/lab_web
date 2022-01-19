package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "visitCountServlet", urlPatterns = { "/visit-count" })
public class VisitCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int count = 0; // visit count
		
		// 브라우저가 보낸 쿠키들을 확인
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				String cookieName = c.getName();
				if(cookieName.equals("visitCount")) {
					count = Integer.parseInt(c.getValue()) + 1;
					break;
				}
			}
		}
		
		
		// 서버에서 브라우저로 VisitCount 이름을 갖는 쿠키를 생성해서 보내줌
		Cookie cookie = new Cookie("visitCount", String.valueOf(count));
		response.addCookie(cookie);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("<html><body>")
		.append("<h1>방문 횟수: " + count + "</h1>")
		.append("</body></html>")
		;
		
//		request.getRequestDispatcher("/WEB-INF/04_visit_count_result.jsp").forward(request, response);
		
		
	}

}
