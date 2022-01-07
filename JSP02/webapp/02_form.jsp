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
        <h1>사용자 이름 입력 페이지</h1>
        <form action="02_result.jsp" method="post">
        	<input type="text" name="userName" placeholder="이름 입력" autofocus required />
        	<input type="submit" value="전송" />
        </form>
    </body>
</html>