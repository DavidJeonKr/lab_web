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
	<title>새 글 작성</title>
	</head>
	<body>
		<div class="container-fluid">
            <nav> <!-- navigation menu -->
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link" href="../">메인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./main">게시판 메인</a>
                    </li>
                    <li class="nav-item">
                        <!-- TODO -->
                        <a class="nav-link" href="./update?bno=${board.bno}">수정하기</a>
                    </li>

                </ul>
            </nav>
            
            <form>
                <div class="form-group">
                    <label for="bno">글 번호</label>
                    <input class="form-control" id="bno" name="bno"
                        type="number" value="${board.bno}" readonly />
                </div>
                <div class="form-group">
                    <label for="title">제목</label>
                    <input class="form-control" id="title" name="title"
                        type="text" value="${board.title}" readonly required />
                </div>
                <div class="form-group">
                    <label for="content" style = "background: black;">내용</label>
                    <textarea class="form-control" id="content" name="content"
                        rows="5" readonly required>${board.content}</textarea>
                </div>
                <div class="form-group">
                    <label for="userId">작성자 아이디</label>
                    <input class="form-control" id="userId" name="userId"
                        type="text" value="${board.userId}" readonly required />
                </div>
                <div class="form-group">
                    <label for="regDate">최종 수정 시간</label>
                    <fmt:formatDate value="${board.regDate}"
                        pattern="yyyy-MM-dd HH:mm:ss"
                        var="regDate" />
                    <input class="form-control" id="regDate" name="regDate"
                        type="text" value="${regDate}" readonly />
                </div>
                <div class="form-group">
                    <label for="viewCount">조회수</label>
                    <input class="form-control" id="viewCount" name="viewCount"
                        type="number" value="${board.viewCount}" readonly />
                </div>
                <div class="form-group">
                    <label for="replyCount">댓글수</label>
                    <input class="form-control" id="replyCount" name="replyCount"
                        type="number" value="${board.replyCount}" readonly />
                </div>
            </form>
            
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>