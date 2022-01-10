<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>EL</title>
    </head>
    <body>
        <h1>숫자 입력 Form</h1>
        <form action="02_number_result.jsp" method="get">
        	<input type="number" name="number1" />
        	<br>       
        	<input type="number" name="number2"  />
        	<br>
        	<input type="submit" value="계산">
        </form>
    </body>
</html>