package edu.web.intro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(name = "firstServlet", urlPatterns = { "/first" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() { // 생성자
        super(); // 부모 클래스(HttpServlet)의 기본 생성자(default constructor)를 명시적으로 호출. 
        // subclass의 생성자에서 superclass의 생성자를 명시적으로 호출하지 않는 경우에는,
        // superclass의 기본 생성자가 자동으로 호출됨!
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override // 부모 클래스(HttpServlet)의 클래스 doGet 메서드를 override(재정의).
    // 클라이언트의 GET 방식의 요청을 처리하는(응답을 만들어 주는) 메서드.
    // 파라미터 request: 클라이언트가 보낸 요청(request)에 대한 정보들을 가지고 있는 객체
    // 파라미터 response: 클라이언트로 보낼 응답(response)를 작성할 떄 필요한 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	System.out.println("firstServlet.doGet() 메서드 호출");
    	Date today = new Date(); // 현재 날짜 & 시간 
    	
    	response.setContentType("text/html; charset=UTF-8"); // 응답: HTML 문서& 인코딩=UTF-8
    	PrintWriter writer = response.getWriter(); // 응답 (response)를 쓰기 위한 write할 수 있는 객체
    	writer.append("<!doctype html>")
    		.append("<html>")
    		.append("<head>")
    		.append("<title>JSP 1</title>")
    		.append("</head>")
    		.append("<body>")
    		.append("<h1>내가 만드는 첫번째 서블릿(Servlet)</h1>")
    		.append("<h2>")
    		.append(today.toString())
    		.append("</h2>")
    		.append("</body>")
    		.append("</html>");
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    // 클라이언트의 POST 방식 요청을 처리하는(응답을 만들어 주는) 메서드.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
    	System.out.println("firstServlet.doPost() 메서드 호출");
    	doGet(request, response);
	}

}