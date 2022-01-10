<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP 2</title>
    </head>
    <body>
        <h1>JSP redirect</h1>
        <%-- 
        페이지 이동 방식:
          1. forward: URL이 유지. request, response 객체 유지. 같은 웹 애플리케이션 안에서만 이동 가능.
          2. redirect: URL이 바뀜. request, response 객체가 유지되지 않음. 같은 서버/다른 서버로 이동 가능.
        --%>
        
        <%--
        // forward 방식 페이지 이동.
        System.out.println("Forward: 06_redirect.jsp --> 06_second.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("06_second.jsp");
        dispatcher.forward(request, response);
        --%>
        
        <%
        // redirect 방식 페이지 이동.
        System.out.println("Redirect: 06_redirect.jsp --> 06_second.jsp");
        response.sendRedirect("06_second.jsp");
        %>
    </body>
</html>