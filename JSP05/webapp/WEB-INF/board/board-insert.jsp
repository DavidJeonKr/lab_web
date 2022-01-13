<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<title>새 글 작성</title>
	</head>
	<body>
		<div class="container-fluid">
			<header>
				<h1 class="jumbotron text-center">새 글 작성 페이지</h1>
			</header>
			
			<nav> <!-- navigation menu  -->
			
			</nav>
			
			<form action="insert" method="post">
				<input class="form-control" type="text" name="title" placeholder="제목" required autofocus="autofocus">
				<textarea class="form-control" rows="5" name="content" placeholder="본문" required></textarea>
				<input class="form-control" type="text" name="userId" placeholder="아이디" value="admin" required >
				<br>
				<input class="btn btn-primary float-right" type="submit" value="작성 완료">
				<input class="btn btn-secondary float-right" type="reset" value="취소">
			</form>
		</div>
	
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>