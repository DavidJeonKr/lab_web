<%@page import="java.util.ArrayList"%>
<%@page import="edu.web.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<title>JSP</title>
	   	<meta name="viewport" content="width=device-width, initial-scale=1">
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
   	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
   	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<h1 class="jumbotron text-center">JSP Scriptlet을 사용한 테이블 작성</h1>
		<h2>Model class 테스트</h2>
		
		<%
		Member member = new Member("admin","1234","admin@naver.com");
		%>
		<div><%= member %>  <!-- m.toString() 호출 --></div>

		<!-- 테이블을 만들 더미 데이터 생성 -->
		<%
		ArrayList<Member> list = new ArrayList<>();
		list.add(member);
		list.add(new Member("guest", "guest", null));
		list.add(new Member("test", "test1234", "test@test.com"));
		list.add(new Member("오썜", "saam000", "jake@itwill.co.kr"));
		%>
		
		<h2 class="text-center">테이블 만들기 1</h2>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
				<% 
				for(Member m : list) {
					out.print("<tr>");
					out.print("<td>" +m.getMemberId() + "</td>");
					out.print("<td>" +m.getMemberPassword() + "</td>");
					out.print("<td>" +m.getMemberEmail() + "</td>");
					out.print("</tr>");
				}
				%>
			</tbody>
		</table>
		
		<h2 class="text-center">테이블 만들기 2</h2>
		<table class="table table-bordered">
			<thead class="table-primary">
				<tr>
					<th>Member ID</th>
					<th>Member Password</th>
					<th>Member Email</th>
				</tr>
			</thead>
			<tbody>
				<% for(Member m : list){ %>
					<tr>
						<td><%= m.getMemberId() %></td>
						<td><%= m.getMemberPassword() %></td>
						<td><%= m.getMemberEmail() %></td>
					</tr>
				<% } %>
			</tbody>
		</table>
		
		
	</body>
</html>