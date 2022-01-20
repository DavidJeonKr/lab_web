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
		<h1>로그인 페이지</h1>
		<form action="signin" method="post">
			<input type="text" name="userId" placeholder="아이디 입력" required autofocus>
			<br>
			<input type="password" name="pwd" placeholder="비밀번호 입력" required>
			<br>
			<input type="submit" value="로그인"> 
		
		</form>
		
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>