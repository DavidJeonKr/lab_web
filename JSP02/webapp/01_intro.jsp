<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 2</title>
<style>
/* CSS comment */
</style>
</head>
<body>
	<h1>JSP 소개</h1>
	
	<% 
	/* Java block comment */
	Date today = new Date(); // 현재 시간
	%>
	
	<h2>서버 시간: <%= today.toString() %></h2>
	
	<%! 
	private String userName;  // 멤버 변수 선언
	
	// 메서드 정의
	public String getUserName() {
		System.out.println("getUserName() 메서드 호출");
		return "오쌤";
	}
	%>
	
	<h2>사용자 이름: <%= getUserName() %></h2>
	
	<!-- HTML 주석 -->
	<script>
	/* JavaScript block comment */
	// JavaScript inline comment
	</script>
</body>
</html>

<%-- JSP 주석(commnet) --%>
<%-- 
Servlet: Server + Applet(웹 Server에서 실행되는 작은 애플리케이션)
  - 자바 클래스.
  - 웹 서버가 요청을 받았을 때 요청을 처리하고 동적으로 HTML 문서를 생성할 수 있는 애플리케이션.
  - 웹 서버의 서블릿 컨테이너가 실행하는 자바 클래스.
  
JSP: Java Server Page
JSP의 동작 원리: jsp -> java -> class -> 메서드 호출
최초 요청(request)이 웹 서버에 도착했을 때, 웹 서버는 JSP가 컴파일된 서블릿 클래스의 객체가 생성됐는 지 검사.
  1. 객체가 생성되어 있는 경우에는, 서블릿 클래스의 doService(doGet, doPost) 메서드를 호출해서 요청을 처리.
  2. 객체가 생성되어 있지 않은 경우에는, JSP가 컴파일된 서블릿 클래스가 있는 지 검사.
     (1) 컴파일된 클래스가 있으면, 서블릿 객체 생성 후 doService 메서드를 호출.
     (2) 컴파일된 클래스가 없으면, JSP를 서블릿 클래스로 컴파일 하고 객체 생성 후 doService를 호출.
JSP의 구성 요소(태그)
  1. 지시문(directive): <%@ ... %>
      page, include, taglib 등을 설정(JSP의 환경 설정 정보)
  2. 선언문(declaration): <%! ... %>
      JSP가 java 파일로 변환될 때, 멤버 변수, 메서드를 정의하는 코드
  3. 스크립트릿(scriptlet): <% ... %>
      JSP가 java 파일로 변환될 때, _jspService(request, response) 메서드 안에 포함되는 코드들.
      지역 변수, 메서드 호출, 조건문, 반복문, ...
  4. 식, 표현식(expression): <%= ... %>
      JSP가 java 파일로 변환될 때, out.print() 메서드의 argument로 전달되는 값. 
      HTML에 바로 표현될 수 있는 식. 변수 이름. 메서드 호출 결과.
  5. 주석(comment)
--%>