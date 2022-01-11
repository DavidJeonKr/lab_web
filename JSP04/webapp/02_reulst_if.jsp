<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
request.setCharacterEncoding("UTF-8"); // (한글 처리를 위해서) POST 방식에서만 필요
String userName = request.getParameter("userName"); // 요청 파라미터 userName의 값을 읽음.
String color = request.getParameter("color"); // 요청 파라미터 color의 값을 읽음.
String colorValue = ""; // 실제 색깔을 저장하기 위한 변수
if (color.equals("r")) {  // 요청 파라미터 color의 값이 "r"이면
	colorValue = "red";
} else if (color.equals("g")) {
	colorValue = "green";
} else if (color.equals("b")) {
	colorValue = "blue";
} else {
	colorValue = "black";
}
%>

<%-- JSTL 태그를 사용한 Java if문 대체 --%>
<c:set var="colorValue2" value="black"></c:set> <%-- 요청 파라미터에 color가 없을 때 사용할 기본값 --%>
<c:if test="${param.color == 'r'}">
	<c:set var="colorValue2" value="red"></c:set>
</c:if>
<c:if test="${param.color == 'g'}">
	<c:set var="colorValue2" value="green"></c:set>
</c:if>
<c:if test="${param.color == 'b'}">
	<c:set var="colorValue2" value="blue"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSTL</title>
        <style>
        span {1
        	color: ${colorValue2}; /* <%=colorValue%>; */
        }
        </style>
    </head>
    <body>
        <h1>scriptlet, exrpession 사용</h1>
        <h2>사용자 이름: <span><%=userName%></span></h2>
        
        <h1>EL, JSTL 사용</h1>
        <h2>사용자 이름: <span>${param.userName}</span></h2>
    </body>
</html>