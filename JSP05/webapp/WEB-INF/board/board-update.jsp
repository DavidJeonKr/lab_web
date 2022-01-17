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
	<title>Insert title here</title>
	</head>
	<body>
		<div class="container-fluid">
		 	<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
        		<div class="container">
        			<a class="navbar-brand" href="../">JSP05</a>
        			<ul class="navbar-nav mr-auto list-group-horizontal-sm">
        				<li class="nav-item active"><a class="nav-link" href="./main">게시판 메인</a></li>
        			</ul>
        			<ul class="nav navbar-nav navbar-right mr-auto">
        				<li class="nav-item active"><a class="nav-link" href="./detail?bno=${board.bno}">이전</a></li>
        			</ul>
        			<ul class="nav navbar-nav navbar-right mr-auto">
        				<li class="nav-item active">
        					<a id="menuDelete" class="nav-link" href="./delete?bno=${board.bno}">삭제하기</a>
        				</li>
        			</ul>
        		</div>
        	</nav>
      </div>
      <br>
      <div>      	
			<h4 class="text-center">회원 정보 수정</h4>
            <form action="update" method="post">
                <div class="form-group">
                    <label for="bno">글 번호</label>
                    <input class="form-control" id="bno" name="bno"
                        type="number" value="${board.bno}" readonly />
                </div>
                <div class="form-group">
                    <label for="title">제목</label>
                    <input class="form-control" id="title" name="title"
                        type="text" value="${board.title}" required />
                </div>
                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea class="form-control" id="content" name="content"
                        rows="5" required>${board.content}</textarea>
                </div>
                <div class="form-group">
                    <label for="userId">작성자 아이디</label>
                    <input class="form-control" id="userId" name="userId"
                        type="text" value="${board.userId}" readonly required />
                </div>
                <input type="submit" value="수정 완료"
                    class="form-control btn btn-outline-primary">
            </form>			
	  </div>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		$(document).ready(function(){
			// 아이디 속성이 menuDelete인 HTML 요소를 클릭했을 때 실행할 이벤트 리스터를 등록.
			$('#menuDelete').click(function(event) {
				//<a> 태그의 클릭 이벤트 기본 동작(요청 보내기)을 하지 못하도록 막음.
				event.preventDefault();
				
				//사용자에게 정말 삭제할 것인 지 확인
				var result = confirm('정말 삭제할까요???');
				if(result) {
					//페이지를 "board/delete?bno=..." 로 이동
					location = $(this).attr('href');
				} 
			})			
		});
		
	</script>    
	</body>
</html>