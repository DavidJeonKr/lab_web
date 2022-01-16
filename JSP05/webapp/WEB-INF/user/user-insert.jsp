<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<title>Insert title here</title>
	</head>
	<body>
	
		<div class="container-fluid">
			
		 	<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
        		<div class="container">
        			<a class="navbar-brand" href="../">JSP05</a>
        		</div>
        	</nav>
			<br>
			<h4 class="mb-3">회원가입</h4>
			<form action="insert" method="post">
				<input class = "form-control"type="text" name="userid" placeholder="아이디"  required autofocus>
				<input class="form-control" type="text" name="pwd" placeholder="패스워드" required>
				<input class="form-control" type="text" name="email" placeholder="이메일" required>
				<br>
				<div class="custom-control custom-checkbox"> <input type="checkbox" class="custom-control-input" id="aggrement" required> <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label> </div>
				<input class="btn btn-primary float-right" type="submit" value="가입 완료">
				<input class="btn btn-secondary float-right" type="reset" value="취소">
			</form>
		</div>
	
	
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>