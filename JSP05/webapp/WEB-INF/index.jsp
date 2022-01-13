<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<title>MVC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>

	</head>
	<body>
		<div class="container-fluid">
		<header class="jumbotron text-center">
		<h1>Main Page</h1>	
		</header>
		
		<nav class="navbar"> <!-- 메인 페이지에서 이동할 수있는 페이지들의 리스트  -->
			<ul class="nav nav-tabs" >
				<li class="nav-item"><a class="nav-link" href="board/main">게시판 메인</a></li>
				<li class="nav-item"><a class="nav-link" href="user/main">사용자 메인 페이지</a></li>
			</ul>
		</nav>
		
		</div>
	 <!-- Bootstrap JavaScript 파일 링크 -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>