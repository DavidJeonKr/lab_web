<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ex02</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container-fluid">
            <header class="jumbotron text-center">
                <h1>게시판 메인</h1>
            </header>
        
            <nav > <!-- 메뉴 -->
                <ul class="navbar">
                <c:if test="${empty signInUserId}">
                    <li class="nav-item">
                        <a class="nav-link" href="../user/signin">로그인</a>
                    </li>
                </c:if>
                <c:if test="${not empty signInUserId}">
                	<li><a href="../user/signout">로그아웃</a></li>
                </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="../">메인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./insert">새 글 작성</a>
                    </li>
                </ul>
            </nav>
            
            <!-- TODO: 검색 창 -->
            <div>
            	<form action="./search" method="get">
            		<select name="type">
            			<option value="1">제목</option>
            			<option value="2">내용</option>
            			<option value="3">제목+내용</option>
            			<option value="4">글쓴이</option>
            		</select>
            		<input type="text" name="keyword" placeholder="검색어 입력" autofocus required>
            		<input type="submit" value="검색">
            	</form>
            </div>
            
            <div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>글 번호</th>
                            <th>글 제목</th>
                            <th>작성자</th>
                            <th>수정 시간</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="board" items="${boardList}">
                            <tr>
                                <td>${board.bno}</td>
                                
                                <td><a href="./detail?bno=${board.bno}">${board.title}</a>
                                <span>[${board.reply_cnt}]</span>
                                </td>
                                
                                <td>${board.userid}</td>
                                <td>
                                    <fmt:formatDate value="${board.reg_date}" pattern="yyyy/MM/dd HH:mm"/>
                                </td>
                                <td>${board.view_cnt}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>