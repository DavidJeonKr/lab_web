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
        <h1>JSP Action Tag</h1>
        <%-- 
        Action Tag: JSP에서 자주 사용되는 자바 코드(기능)들을 미리 태그 형태로 구현한 문법.
          * <jsp:forward>
          * <jsp:include>
          * <jsp:useBeans>
          * ...
        --%>
        
        <jsp:forward page="06_second.jsp"></jsp:forward>
        <%-- redirect는 JSP 표준 액션 태그로 구현되어 있지 않음! --%>
    </body>
</html>