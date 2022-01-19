package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "sessionTestServlet", urlPatterns = { "/session-test" })
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO: WAS에서 Session에 정보를 저장
		// 1. Session 객체 생성.
		// request.getSession():
		// - 클라이언트가 요청과 함께 전달한 세션 아이디와 매핑되어 있는 세션 객체를 리턴
		// - 클라이언트가 세션 아이디를 보내지 않은 경우에는 새로운 세션 객체를 생성해서 리턴
		// request.getSession(boolean create):
		// - 클라이언트가 요청과 함께 전달한 세션 아이디와 매핑되어 있는 세션 객체를 리턴
		// - 클라이언트가 세션 아이디를 보내지 않은 경우에,
		//   (1) argument가 true이면 새로운 세션 객체를 생성해서 리턴
		//   (2) argument가 false이면 null을 리턴
		HttpSession session = request.getSession();
		
		// 2. 세션 객체에 필요한 데이터를 저장.
		session.setAttribute("userName", "관리자");
		// 3. 세션 만료 기간 설정 - 단위 초(second)
		session.setMaxInactiveInterval(60); // 5분 후 세션 만료
		
		
		request.getRequestDispatcher("/WEB-INF/03_session_test.jsp").forward(request, response);
	}

}
