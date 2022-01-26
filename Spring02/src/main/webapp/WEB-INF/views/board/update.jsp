<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<header class="text-center">
				<h1>게시글 수정 페이지</h1> 
			</header>
			
			<nav> <!-- TODO: 페이지 이동 메뉴  -->
				<ul class="navbar">
					<li class="nav-item"><a class="nav-link" href="../">메인</a></li>
					<li class="nav-item"><a class="nav-link" href="./main">게시판 메인</a></li>
					<li  class="nav-item"><a id="menu-delete" class="nav-link" href="./delete?bno=${board.bno}">삭제</a></li>
				</ul>
			</nav>
			
			<div>
				<form method="post">
					<div style="display: none;">
						<input type="text" name="bno" value="${board.bno}" readonly />
					</div>
					<div>
						<label for="title">글 제목</label>
						<input class="form-control" type="text" id="title" name="title" value="${board.title}" required autofocus>
					</div>
					
					<div>
						<label for="content">글 내용</label>
						<textarea class="form-control" rows="5" id="content" name="content" required>${board.content}</textarea>
					</div>
					
					<div>
						<label for="userid">작성자</label>
						<input class="form-control" type="text" value="${board.userid}" id="userid" name="userid" readonly required >
					</div>
					
					<div>
						<label for="reg_date">최종 수정 시간</label>
						<fmt:formatDate value="${board.reg_date}" pattern="yyyy/MM/dd HH:mm:ss" var="last_update_time"/>
						<input class="form-control" type="text" id="reg_date" name="reg_date" value="${last_update_time}" readonly>
					</div>
					
					<div>
						<label for="view_cnt">조회 수</label>
						<input class="form-control" type="text" id="view_cnt" name="view_cnt" value="${board.view_cnt}" required readonly>
					</div>
					<br>
					<div>
						<input class="btn btn-primary" type="submit" value="수정 완료">
					</div>
				</form>
			</div>
		</div>
	
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script>
    	$(document).ready(function() {
    		$('#menu-delete').click(function(event){
				event.preventDefault(); // 링크 클릭했을 때의 기본 동작인 요청 보내기를 하지 않음.
				var result = confirm('정말 삭제 하시겠습니까?');
				if(result) {
					location = $(this).attr("href"); // 원래 이동하려고 했던 요청 주소로 요청 보내기
				} 
    		});
    	});
    </script>
	</body>
</html>