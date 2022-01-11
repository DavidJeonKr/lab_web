<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSTL</title>
    </head>
    <body>
        <h1>JSTL formatDate 태그</h1>
        <c:set var="now" value="<%=new Date() %>"></c:set>
        ${now}
        <br>
        <fmt:formatDate value="${now}"/>
        <br>
        time type: <fmt:formatDate value="${now}" type="time"/>
        <br>
        date type: <fmt:formatDate value="${now}" type="date"/>
        <br>
        both type: <fmt:formatDate value="${now}" type="both"/>
        <br>
        <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
        <br>
        <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/>
        <br>
    </body>
</html>