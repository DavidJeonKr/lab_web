<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<title>ex02</title>
	</head>
	<body>
		<div class="container-fluid">
			<header>
				<h1 class="text-center">로그인 페이지</h1>
			</header>
		</div>
		
		<nav> <!-- TODO: 페이지 이동 메뉴 -->
			<div class="row text-center" style="width: 100%">
				<form action="./signin" method="post">
					<div style="width: 30%; float:none; margin:0 auto">
						<input type="text" name="userid" placeholder="아이디 입력" required> 
					</div>
					<div style="width: 30%; float:none; margin:0 auto">
						<input type="password" name="pwd" placeholder="비밀번호 입력" required>
					</div>
					<div style="width: 30%; float:none; margin:0 auto">
						<input type="submit" value="로그인">
					</div>
				</form>
			</div>			
		</nav>
	
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>