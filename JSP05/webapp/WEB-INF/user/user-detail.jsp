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
			
		 	<nav class="navbar navbar-dark bg-dark navbar-expand-md">
        		<div class="container">
        			<a class="navbar-brand" href="../">JSP05</a>
        			<ul class="navbar-nav mr-auto list-group-horizontal-sm">
        				<li class="nav-item active"><a class="nav-link" href="./main">게시판 메인</a></li>
        			</ul>
        			<ul class="nav navbar-nav navbar-right">
        				<li class="nav-item active"><a class="nav-link">수정하기</a></li>
        			</ul>
        		</div>
        	</nav>
			<br>
			<h4 class="mb-3">회원 정보</h4>

			<form>
				 <div class="form-group">
                    <label for="userid">아이디</label>
                    <input class="form-control" id="userid" name="pwd"
                        type="text" value="${user.userid}" readonly/>
                </div>
				 <div class="form-group">
                    <label for="pwd">패스워드</label>
                    <input class="form-control" id="pwd" name="pwd"
                        type="password" value="${user.pwd}" />
                </div>                
				 <div class="form-group">
                    <label for="email">이메일</label>
                    <input class="form-control" id="email" name="email"
                        type="text" value="${user.email}" />
                </div>                
				 <div class="form-group">
                    <label for="points">포인트</label>
                    <input class="form-control" id="points" name="points"
                        type="text" value="${user.points}" />
                </div>                
			
			</form>
						
			
			
		</div>
	
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>