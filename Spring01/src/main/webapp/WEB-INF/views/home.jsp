<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- <% response.setContentType("text/html; charset=UTF-8"); --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> who is my ${person}.</p>

<hr>

	<ul>
		<li><a href="sample1">샘플 페이지1</a></li>
		<li><a href="sample2">샘플 페이지2</a></li>
	</ul>
</body>
</html>
