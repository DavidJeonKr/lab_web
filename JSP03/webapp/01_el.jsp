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
        <h1>EL(Expression Language): (표현)식 언어</h1>
        <h2>${ "Hello, EL!" }</h2>
        <%-- 
        EL(Expression Language)
          * ${ 식(expression) }
            -> 식(expression): 변수. 메서드 호출. 연산 식.
          * 지시자(directive, <%@ ... %>) 안에서는 사용 불가.
          * 선언문(declaration, <%! ... %>) 안에서는 사용 불가.
          * 스크립트릿(scriptlet, <% ... %>) 안에서는 사용 불가.
          * 식(expression, <%= ... %>) 안에서는 사용 불가.
          * JSP 태그 요소들(directive, declaration, scriptlet, expression)을 제외한 나머지 모든 곳에서 사용 가능.
            - HTML 태그의 컨텐트로 사용 가능.
            - HTML 태그의 속성(attribute) 값을 설정할 때 사용 가능.
            - CSS 스타일 속성(property) 값을 설정할 때 사용 가능.
            - JavaScript 안에서도 사용 가능.
        --%>
        
        ${ 1 + 2 } <br>
        ${ 1 / 2 } <br>
        ${ 1 == 2 } <br>
        <%-- 
          EL에서 문자열은 큰따옴표("")와 작은따옴표('') 모두 사용 가능. 
          EL에서 사칙연산(+, -, *, /)은 숫자 타입만 가능. 문자열에서 + 기능은 없음!
        --%>
        <%= "100" + "200" %> <br>
        ${ "100" + "200" } <br> <%-- 문자열 "100", "200"이 숫자 100, 200으로로 변환된 후 덧셈 --%>
        
    </body>
</html>