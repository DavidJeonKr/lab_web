<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>MVC</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container-fluid">
        	<header class="jumbotron text-center">
        		<h1>게시판 메인 페이지</h1>
        	</header>
        	
        	<nav> <!-- 게시판 기능 메뉴 -->
        		<ul class="nav nav-tabs bg-dark">
        			<li class="nav-item">
        				<a class="nav-link" href="../">메인 페이지 돌아가기</a>
        			</li>
        			<li class="nav-item">
        				<a class="nav-link" href="insert">새 글 작성</a>
        			</li>
        		</ul>
        	</nav>
        	
            <div> <!-- 검색 기능 -->
                <form action="search" method="get">
                    <select name="type">
                        <option value="1">제목</option>
                        <option value="2">내용</option>
                        <option value="3">제목 + 내용</option>
                        <option value="4">작성자</option>
                    </select>
                    <input type="text" name="keyword" placeholder="검색어 입력" required />
                    <input class="btn btn-secondary" type="submit" value="검색" />
                </form>
            </div>
        	
        	<div> <!-- 게시판 목록 테이블 -->
        		<table class="table table-hover">
        			<thead>
        				<tr>
	        				<th>번호</th>
	        				<th>제목</th>
	        				<th>작성자</th>
	        				<th>수정 시간</th>
	        				<th>조회수</th>
        				</tr>
        			</thead>
        			<tbody>
        				<%-- ${boardList}: BoardMainController에서 request 객체에 저장(setAttribute)한 List 객체 --%>
        				<c:forEach var="b" items="${boardList}">
        					<tr>
        						<%-- ${b.bno}: Board 객체 b의 getBno() 메서드 호출 결과 --%>
        						<td>${b.bno}</td>
        						<td><a href="detail?bno=${b.bno}">${b.title}</a></td>
        						<td>${b.userId}</td>
        						<fmt:formatDate value="${b.regDate}" 
        							pattern="yyyy-MM-dd HH:mm:ss"
        							var="reg_date" />
        						<td>${reg_date}</td>
        						<td>${b.viewCount}</td>
        					</tr>
        				</c:forEach>
        			</tbody>
        		</table>
        	</div>
        	
        	<div> <!-- 검색 -->
        	</div>
        	
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>