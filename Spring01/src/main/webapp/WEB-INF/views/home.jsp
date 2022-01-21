<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- <% response.setContentType("text/html; charset=UTF-8"); --%>
<html>
<head>
	<title>Home</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> who is my ${person}.</p>

<hr>

	<ul class="list-group">
		<li class="list-group-item"><a href="sample1">샘플 페이지1</a></li>
		<li class="list-group-item"><a href="sample2">샘플 페이지2</a></li>
		<li class="list-group-item"><a href="board/main">게시판 메인 페이지</a></li>
		<li class="list-group-item"><a href="board/insert">새 글 작성</a></li>
		
	</ul>
	
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
