package edu.web.intro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet 클래스는 처리할 수 있는 URL 패턴을 매핑시켜야 함.
// URL 패턴 매핑 방법 1: @webServlet 어노테이션(annotation)을 이용.
// URL 패턴 매핑 방법 2: 배포 관리자(deployment descriptor, web.xml)에서 설정
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForwardTestServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("forwardTestServlet.doGet() 메서드 호출");
		// 전달받은 요청(request)를 JSP 페이지에게 재전송(forward)
		RequestDispatcher dispatcher = request.getRequestDispatcher("forward.jsp");
		dispatcher.forward(request, response);
		
		// forward 방식의 페이지 이동:
		// 클라이언트가 보낸 요청(request)을 유지하면서 새로운 페이지로 이동.
		// request, response 객체가 유지됨.
		// 같은 서버의 같은 웹 애플리케이션 안에서만 페이지 이동이 가능.
		// 다른 서버, 다른 웹 애플리케이션으로 페이지 이동은 불가능
		// 페이지가 이동하더라도 요청 URL 주소가 유지됨(변경되지 않음).
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("forwardTestServlet.doPost() 메서드 호출");
	}

}
