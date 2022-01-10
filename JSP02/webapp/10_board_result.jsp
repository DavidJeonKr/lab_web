<%@page import="edu.web.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP 2</title>
    </head>
    <body>
        <h1>게시판 글쓰기 결과 페이지</h1>
        <% 
        // form에서 POST 방식으로 보낸 데이터(요청 파라미터)의 한글을 제대로 처리하기 위해
        request.setCharacterEncoding("UTF-8");
        %>
        
        <h2>scriptlet, expression 사용</h2>
        <%
        // form에서 전송한 요청 파라미터 값 읽기
        int boardId = Integer.parseInt(request.getParameter("boardId")); // 글 번호
        String title = request.getParameter("title"); // 글 제목
        String content = request.getParameter("content"); // 글 본문
        String writer = request.getParameter("writer");  // 작성자 아이디
        
        // Board 객체 생성
        Board b1 = new Board();  // 기본 생성자 호출
        // setter 메서드를 호출해서 멤버 변수를 초기화.
        b1.setBoardId(boardId);
        b1.setTitle(title);
        b1.setContent(content);
        b1.setwriter(writer);
        %>
        
        <div>
        글 번호: <%= b1.getBoardId() %> <br>
        글 제목: <%= b1.getTitle() %> <br>
        글 본문: <%= b1.getContent() %> <br>
        작성자: <%= b1.getwriter() %> <br>
        </div>
        
        <h2>JSP 표준 액션 태그 사용</h2>
        <%-- 1. Java Bean 객체 생성 --%>
        <jsp:useBean id="b2" class="edu.web.model.Board"></jsp:useBean>
        
        <%-- 2. 요청 파라미터(request parameter) 값들로 Java Bean 객체의 프로퍼티 값을 설정 --%>
        <%--
        <jsp:setProperty property="boardId" name="b2" param="boardId" />
        <jsp:setProperty property="title" name="b2" param="title" />
        <jsp:setProperty property="content" name="b2" param="content" />
        <jsp:setProperty property="writer" name="b2" param="writer" />
        --%>
        
        <jsp:setProperty property="*" name="b2" />
        <%-- 요청 파라미터를 모두 이용해서 Java bean 객체 b2의 모든 속성들의 값을 설정 --%>
        
        <%-- 3. 출력 --%>
        <div>
        글 번호: <jsp:getProperty property="boardId" name="b2" /> <br>
        글 제목: <jsp:getProperty property="title" name="b2" /> <br>
        글 본문: <jsp:getProperty property="content" name="b2" /> <br>
        작성자: <jsp:getProperty property="writer" name="b2" /> <br>
        </div>
        
    </body>
</html>