<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSTL</title>
    </head>
    <body>
        <h1>JSTL url, param 태그</h1>
        <ul>
        	<li>
        		<a href="02_result_if.jsp?color=r&userName=ad&min">테스트 1</a>
        	</li>
        	<li>
        		<c:url var="testURL" value="02_result_if.jsp">
        			<c:param name="color" value="r"></c:param>
        			<c:param name="userName" value="홍&길동"></c:param>
        		</c:url>
        		<a href="${testURL}">테스트 2</a>
        	</li>
        </ul>
    </body>
</html>