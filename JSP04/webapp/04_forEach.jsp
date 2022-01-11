<%@ page import="edu.web.model.Member"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSTL</title>
    </head>
    <body>
        <h1>JSTL forEach list</h1>
        
        <%
        // 리스트 아이템으로 사용할 더미 데이터
        String[] actors = {"이정재", "박해수", "오영수", "정호연", "허성태"};
        
        // script에서 선언한 지역 변수는 EL에서 사용할 수 없음.
        // EL에서 사용할 수 있는 변수는 pageContext, request, session, application의 속성(attribute)들
        pageContext.setAttribute("actorList", actors);
        %>
        
        <ul>
        <% for (String s: actors) { %>
        	<li><%=s%></li>
        <% } %>
        </ul>
        
        <ul>
        	<c:forEach var="actor" items="${actorList}">
        		<li>${actor}</li>
        	</c:forEach>
        </ul>
        
        <h1>JSTL forEach table</h1>
        <%
        // 테이블의 row(행) 데이터로 사용할 더미 데이터
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member("admin", "0000", "admin@itwill.co.kr"));
        list.add(new Member("guest", "guest", null));
        list.add(new Member("test", "test1111", "test@test.com"));
        
        request.setAttribute("memberList", list);
        %>
        
        <h2>scriptlet, expression</h2>
        <table>
        	<thead>
        		<tr>
        			<th>ID</th>
        			<th>Password</th>
        			<th>Email</th>
        		</tr>
        	</thead>
        	<tbody>
        	<% for (Member m : list) { %>
        		<tr>
        			<td><%=m.getMemberId()%></td>
        			<td><%=m.getMemberPassword()%></td>
        			<td><%=m.getMemberEmail()%></td>
        		</tr>
        	<% } %>
        	</tbody>
        </table>
        
        <h2>JSTL, EL</h2>
        <table>
        	<thead>
        		<tr>
        			<th>아이디</th>
        			<th>비밀번호</th>
        			<th>이메일</th>
        		</tr>
        	</thead>
        	<tbody>
        		<c:forEach items="${memberList}" var="m">
        			<tr>
        				<td>${m.memberId}</td>
        				<td>${m.memberPassword}</td>
        				<td>${m.memberEmail}</td>
        			</tr>
        		</c:forEach>
        	</tbody>
        </table>
        
    </body>
</html>