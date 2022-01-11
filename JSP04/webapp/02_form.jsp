<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSTL</title>
    </head>
    <body>
        <h1>입력 페이지</h1>
        <form action="02_result_if.jsp" method="get">
        	<input type="text" name="userName" placeholder="사용자 이름 입력" />
        	<br>
        	<select name="color">
        		<option value="r">Red</option>
        		<option value="g">Green</option>
        		<option value="b">Blue</option>
        	</select>
        	<br>
        	<input type="submit" value="전송" />
        </form>
    </body>
</html>