package edu.web.intro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RedirectTestServlet() {}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("redirectTestServlet.doGet() 메서드 호출");
		
		// redirect 방식의 페이지 이동:
		// 최초 요청(request)을 받은 페이지가 응답(response)를 처리하지 않음
		// request와 response 객체가 유지되지 않음
		// 최초 요청을 받은 페이지에서 새로운 request, response 객체를 생성하고 페이지를 이동.
		// 최초 요청 URL이 유지되지 않고, 이동되는 페이지 주소로 URL이 변경.
		// 같은 웹 서버 내부 또는 외부 서버의 주소로 모두 이동이 가능.
		
		response.sendRedirect("redirect.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("redirectTestServlet.doPost() 메서드 호출");
	}

}
