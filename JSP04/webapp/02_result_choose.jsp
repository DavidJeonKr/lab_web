<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${param.color == 'r'}">
		<c:set var="colorValue" value="red"></c:set>
	</c:when>
	<c:when test="${param.color == 'g'}">
		<c:set var="colorValue" value="green"></c:set>
	</c:when>
	<c:when test="${param.color == 'b'}">
		<c:set var="colorValue" value="blue"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="colorValue" value="black"></c:set>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<title>JSP 04</title>
	</head>
	<body>
	
	
	</body>
</html>