<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<title>Session</title>
	</head>
	<body>
	<h1>Session Test</h1>
	
	<%
	// 세션에 저장된 userName 정보를 읽어서 화면에 표시
	String user= (String) session.getAttribute("userName");
	%>
	<div>사용자 이름: <%=user%></div>
	
	<h2>EL(Expression Language)</h2>
	<div>
	사용자 이름: ${userName}
	</div>
	<div>사용자 이름: ${sessionScope.userName}</div>
	<div>사용자 이름: ${sessionScope["userName"]}</div>
	
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>