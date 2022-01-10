
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>EL</title>
    </head>
    <body>
        <h1>JSP 내장 객체 vs EL 내장 객체</h1>
        <%-- 
        JSP에서 상태 정보들을 유지하기 위해서 사용하는 객체들:
          * pageContext: JSP 페이지가 유지되는 동안 유지되는 객체. <% pageContext.get(); %>
          * request: 요청(request)이 유지되는 동안 유지되는 객체. <% request.getParameter(); %>
          * session: 세션(session)이 유지되는 동안 유지되는 객체.
          * application: 웹 애플리케이션이 동작 중(서버 실행 중)에 계속 유지되는 객체.
        EL에서 상태 정보들을 유지하기 위해서 사용하는 객체들:
          * pageScope: ${ pageScope }. JSP의 pageContext 객체.
          * requestScope: ${ requestScope }. JSP의 request 객체.
          * sessionScope: ${ sessionScope }. JSP의 session 객체.
          * applicationScope: ${ applicationScope }. JSP의 application 객체.
          
        EL ${ 변수 }의 동작 원리:
          * EL은 변수 이름을 pageScope -> requestScope -> sessionScope -> applicationScope 순으로 찾음.
          * { 변수 }: JSP의 내장 객체(pageContext, request, session, application)의 속성 이름.
        --%>
        
        <h2>JSP scriptlet & expression</h2>
        <%
        // pageContext 객체에 "number1" 속성 값을 1로 설정
        pageContext.setAttribute("number1", 1);
        // request 객체에 "number2" 속성 값을 2로 설정
        request.setAttribute("number2", 2);
        session.setAttribute("number3", 3);
        application.setAttribute("number4", 4);
        %>
        
        <div>
        page 속성: <%= pageContext.getAttribute("number1") %> <br>
        request 속성: <%= request.getAttribute("number2") %> <br>
        session 속성: <%= session.getAttribute("number3") %> <br>
        application 속성: <%= application.getAttribute("number4") %> <br>
        </div>
        
        <h2>EL</h2>
        <div>
        page 속성: ${ number1 } <br>  <%-- ${pageScope.number1} 동일 --%>
        request 속성: ${ number2 } <br> <%-- ${pageScope.number2} 찾음 => ${requestScope.number2} --%>
        session 속성: ${ number3 } <br>
        application 속성: ${ number4 } <br>
        </div>
        <!-- 챕터 14 JSTL, 마무리가 되면 11장에 jdbc연결   -->
        <!-- 실제 서비스가 되는 -->
    </body>
</html>