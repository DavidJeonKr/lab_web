<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<title>JSP 2</title>
	</head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
   	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
   	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
   	<link href="css/mystyle.css" rel="stylesheet" />
	<body>
	
		<!-- JSP (메인) 페이지에서 다른 JSP, JSPF, HTML을 포함시키고자 할 떄 -->
		<%@include file="05_header.jspf" %>
		<section class="main">	
			<h1>include directive(지시자)</h1>
			<h2>메인 페이지</h2>
		</section>
		<%@include file="05_footer.jsp" %>
	<!-- Today what i lean  -->
	<!-- JSP 주말 동안에 챕터 8 챕터 9장 -->
	<!-- Servlet 1장 2장 3장, jsp 8장 9장 복습 -->
	<!-- 123 -->
</html>