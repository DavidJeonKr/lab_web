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
    
    	<%@ include file="05_header.jspf" %>
    	
        <h1>JSP 표준 액션 태그를 사용한 페이지 include</h1>
        
        <jsp:include page="05_footer.jsp"></jsp:include>
        
        <%-- 
        JSP 페이지에서 다른 JSP 또는 HTML 파일을 포함시키는 방법:
          1. <%@ include file="..." %> 지시자(dierctive)를 사용
             include 지시자 위치에 파일의 내용이 삽입된 후, 하나의 JSP 파일이 하나의 클래스로 컴파일 됨.
             jspf 확장자를 갖는 파일도 포함할 수 있음.
          2. <jsp:include file="..." ></jsp:include> 액션 태그를 사용
             각각의 JSP 파일들이 컴파일 되고, 각각의 서블릿 클래스들이 생성됨.
             jspf 확장자를 갖는 파일은 포함시킬 수 없음.
        --%>
    </body>
</html>