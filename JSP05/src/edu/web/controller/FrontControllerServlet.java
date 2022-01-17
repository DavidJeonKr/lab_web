package edu.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.board.BoardDeleteController;
import edu.web.controller.board.BoardDetailController;
import edu.web.controller.board.BoardInsertController;
import edu.web.controller.board.BoardMainController;
import edu.web.controller.board.BoardSearchController;
import edu.web.controller.board.BoardUpdateController;
import edu.web.controller.user.UserDetailController;
import edu.web.controller.user.UserInsertController;
import edu.web.controller.user.UserMainController;

import static edu.web.controller.Action.REDIRECT_PREFIX;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet(
		name = "frontControllerServlet", 
		urlPatterns = { "", "/board/*", "/user/*" }
		)
// @WebServlet 어노테이션의 urlPatterns 설정값: 
// - Servlet 클래스가 처리할 URL 주소들의 배열(String[]).
// - URL 주소에서 Context Path 아래의 주소들을 설정.
// (예) URL 주소가 "http://localhost:8181/JSP05/board/main" 라면 매핑 패턴은 "/board/main".
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 요청(request)과 응답(response)을 처리하는 Controller 객체들과 
	// Controller에 매핑된 요청 주소를 저장하는 변수
	private Map<String, Action> commands;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    // WAS(Web Application Server)가 서블릿(Servlet) 클래스 객체를 생성할 때 한 번 호출하는 메서드.
 	// 서블릿 객체가 생성될 때 필요한 초기화 작업(환경 설정) 등을 담당.
	public void init(ServletConfig config) throws ServletException {
		// 요청 주소와 요청 주소를 처리할 Controller 클래스의 객체를 매핑시켜서 등록.
		commands = new HashMap<String, Action>();
		
		commands.put("/", new MainController());
		commands.put("/board/main", new BoardMainController());
		commands.put("/board/insert", new BoardInsertController());
		commands.put("/board/detail", new BoardDetailController());
		commands.put("/board/update", new BoardUpdateController());
		commands.put("/board/delete", new BoardDeleteController());
		commands.put("/board/search", new BoardSearchController());
		
		commands.put("/user/main", new UserMainController());
		commands.put("/user/insert", new UserInsertController());
		commands.put("/user/detail", new UserDetailController());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	// 클라이언트에서 요청이 올 때마다 요청을 처리하고 응답을 보내기 위해서 WAS가 호출하는 메서드.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("frontControllerServlet.service() 메서드 호출");
		
		// request 객체가 가지고 있는 정보들
		// URL: 프로토콜(protocol) + 서버 주소(이름) + 포트번호 + URI(Context Path + 하위 주소 + Query String)
		StringBuffer url = request.getRequestURL();
		System.out.println("Request URL: " + url);
		
		String uri = request.getRequestURI();
		System.out.println("Request URI: " + uri);
		
		String contextPath = request.getContextPath();
		System.out.println("Context Path: " + contextPath);
		
		String path = uri.substring(contextPath.length());
		System.out.println("path: " + path);
		
		// 요청 파라미터(request parameter)에 포함되어 있는 한글을 처리하기 위해서
		request.setCharacterEncoding("UTF-8");
		
		// 위임(delegation) 패턴 사용: 요청 주소를 처리하기 위한 Controller 객체 찾음.
		Action controller = commands.get(path);
		// Controller가 request를 처리한 후에 View를 만들기 위한 JSP 파일 경로를 리턴받음.
		String view = controller.execute(request, response); // 위임(delegation)
		System.out.println("view: " + view);
		
		// TODO: forward vs redirect 선택 : view가 "rediredt:" 문자열로 시작하는 지를 체크
		if(view.startsWith(REDIRECT_PREFIX)) { //view가 "redirect:" 로 시작
			// "redirect:" 접두사를 제거하고, 페이지를 redirect 방식으로 이동
			String target = view.substring(REDIRECT_PREFIX.length());
			System.out.println("target: " + target);
			response.sendRedirect(target);
		} else {
			// 요청을 View 페이지로 이동(forward)
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
	}

}