package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "readCookieServlet", urlPatterns = { "/get-cookie" })
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클리이언트(브라우저)가 요청(requst)에 실어서 보낸
		Cookie[] cookies = request.getCookies();
		// getCookies() 메서드는 웹 브라우저에서 전송된 쿠기가 없는 경우에는 null을 리턴.
		if(cookies != null) { // 쿠키 배열이 null이 아닌 경우에
			for(Cookie c : cookies) {
				String name = c.getName(); // 쿠키 이름
				String value = c.getValue(); // 쿠키에 저장된 값
				System.out.println(name + " + " + value);
				
				// 서버에서 응답을 보낼 때 클라이언트(브라우저)가 저장하고 있는 쿠키를 만료시키는 방법 
				if(name.equals("nickName")) {
					// 만료시킬 쿠키와 동일한 같은 이름의 쿠키 객체를 생성.
					Cookie nickName = new Cookie("nickName", null);
					// 새로 생성된 쿠키의 만료 기간은 0초로 설정.
					nickName.setMaxAge(0);
					//쿠키를 응답에 포함
					response.addCookie(nickName);
				}
			}
		}
		
		//Servlet -> View(JSP) 포워드
		request.getRequestDispatcher("/WEB-INF/02_read_result.jsp").forward(request, response);
		
		
		
		
	}

}
