<%@page import="java.util.Date"%>
<%@page import="edu.web.model.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<title>JSP 2</title>
		   	<meta name="viewport" content="width=device-width, initial-scale=1">
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
   	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
   	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<h1 class = "jumbotron text-center">JSP Scriptlet과 expression을 사용한 테이블 작성</h1>
		
		<%
			Date today = new Date();
			ArrayList<Board> list = new ArrayList<>();
			list.add(new Board(1,"첫번째 글제목", "글 본문", "작성자 아이디", today, 0));
			list.add(new Board(2,"이상한 이야기", "옛날 옛적에", "이솝", today, 10));
			list.add(new Board(3,"훈민정음", "가나다라마바사아자차카타파하", "세종대왕님", today, 10));
		%>
		
		<table class="table table-striped">
			<thead>
				<tr class="thead-dark">
					<th scope="col">글 번호</th>
					<th scope="col">글 제목</th>
					<th scope="col">본 문</th>
					<th scope="col">아이디</th>
					<th scope="col">작성 시간</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
			<% for(Board b : list) { %>
				<tr>
					<td><%=b.getBoardId() %></td>
					<td><%=b.getTitle() %></td>
					<td><%=b.getContent()%></td>
					<td><%= b.getwriter()%></td>
					<td><%=b.getUpdateTime() %></td>
					<td><%= b.getViewCount()%></td>
				</tr>
			<% } %>
			</tbody>
			
		</table>
			
		
		
	</body>
</html>