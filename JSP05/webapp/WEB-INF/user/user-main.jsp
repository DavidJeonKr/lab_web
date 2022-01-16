<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container-fluid">
        	<header class="jumbotron text-center bg-dark text-white">
        		<h1>사용자 메인 페이지</h1>
        	</header>
        </div>
        <nav class="navbar navbar-dark bg-dark navbar-expand-lg">
        	<div class="container">
        		<a class="navbar-brand" href="../">JSP05</a>
        		<ul class ="navbar-nav">
        			<li class="nav-item acitve float-right">
        			<a class="nav-link" href="insert">회원 가입</a>
        			</li>
        		</ul>        		
        	</div>
        </nav>
        <br>
        <div>
        	<table class="table table-hober">
        		<thead>
        			<tr>
        				<th>아이디</th>
        				<th>이메일</th>
        				<th>포인트</th>
        			</tr>
        		</thead>
        		<tbody>
        			<c:forEach var="u" items="${userList}">
        				<tr>
							<td><a href="detail?userid=${u.userid}">${u.userid}</a></td>
							<td>${u.email}</td>
							<td>${u.points}</td>
        				</tr>
        			</c:forEach> 
        		</tbody>
        	</table>
        
        
        </div>
        
        
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>