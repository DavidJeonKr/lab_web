<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP 2</title>
   	<meta name="viewport" content="width=device-width, initial-scale=1">
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
   	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
   	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h1 class="jumbotron text-center">사용자 이름 결과 페이지</h1>
        
        <% // scriptlet
        request.setCharacterEncoding("UTF-8"); // 요청 데이터의 문자열 인코딩 방식 설정
        String userName = request.getParameter("userName"); // form에서 userName으로 전달한 파라미터 값
        %>
        
        <hr>
		<h1>out 객체 직접 사용</h1>
		        
		<%
		if(userName.equals("admin")){
			out.print("<h2 class='p-3 mb-2 bg-primary text-white'>관리자 페이지</h2>");
		} else {
			out.print("<h2 class='p-3 mb-2 bg-secondary text-white'>사용자 이름: " + userName + "</h2>");
		}
		%>        
        
        <hr>
        <h1>scriptlet과 expression 사용</h1>
        <% if(userName.equals("admin")) { %>
			<h2 class="class='p-3 mb-2 bg-primary text-white">관리자 페이지</h2>        	
        <% } else { %>
        	<h2 class="class='p-3 mb-2 bg-secondary text-white">사용자 이름: <%= userName %></h2>
        <% } %>
    </body>
</html>