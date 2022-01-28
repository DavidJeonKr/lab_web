<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<title>ex2</title>
	</head>
	<body>
	<div class = "container-fluid">
		<header class="jumbotron text-center">
			<h1>메인페이지</h1>
		</header>
		
		<nav>
			<ul> <!-- TODO: -->
			<c:if test="${empty signInUserId}"> <!-- 로그인 되어 있지 않은 경우 -->
				<li><a href="./user/register">회원가입</a></li>
				<li><a href="./user/signin">로그인</a></li>
			</c:if>
			<c:if test="${not empty signInUserId}"> <!-- 로그인 되어 있는 경우 -->
				<li><a href="./user/signout">로그아웃</a></li>
			</c:if>
				<li><a href="./board/main">게시판</a></li>
			</ul>
		</nav>
	</div>
	
	
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>