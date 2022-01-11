<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSTL</title>
    </head>
    <body>
        <h1>JSTL formatNumber 태그</h1>
        <c:set var="number1" value="1234567890.123456789"></c:set>
        ${number1}
        <br>
        <fmt:formatNumber value="${number1}"></fmt:formatNumber>
        <br>
        <fmt:formatNumber value="${number1}" 
        	maxFractionDigits="5"
        	groupingUsed="false"></fmt:formatNumber>
        <%-- 
        maxFractionDigit=표현할 수 있는 소수점 이하 최대 자릿수. 기본값은 3.
        groupingUsed=1000자리 구분자를 사용할 지 여부. 기본값은 true.
        --%>
        <br>
        number type: <fmt:formatNumber value="1000" type="number"></fmt:formatNumber>
        <br>
        currency type: <fmt:formatNumber value="1000" type="currency"></fmt:formatNumber>
        <br>
        percentage type: <fmt:formatNumber value="0.9" type="percent"></fmt:formatNumber>
    </body>
</html>