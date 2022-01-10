<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP</title>
    </head>
    <body>
        <h1>게시판 글 쓰기</h1>
        <form action="10_board_result.jsp" method="post">
        	<input type="number" name="boardId" placeholder="글 번호" />
        	<br>
        	<input type="text" name="title" placeholder="글 제목" />
        	<br>
        	<textarea name="content" rows="5" cols="80" placeholder="글 본문"></textarea>
        	<br>
        	<input type="text" name="writer" placeholder="작성자 아이디" />
        	<br>
        	
        	<input type="submit" value="작성 완료" />
        </form>
    </body>
</html>