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
        <h1>결과 페이지</h1>
        <h2>JSP scriptlet, expression 이용</h2>
        <%
        request.setCharacterEncoding("UTF-8"); // POST 방식의 데이터 전송에서 한글 처리
        
        // 요청 파라미터(request parameter)의 값들을 찾음.
        String param1 = request.getParameter("number1");
        String param2 = request.getParameter("number2");
        
        // 요청 파라미터 값들을 int 타입으로 변환
        int number1 = Integer.parseInt(param1);
        int number2 = Integer.parseInt(param2);
        %>
        
        <%= number1 %> + <%= number2 %> = <%= number1 + number2 %>
        <br>
        <%= number1 %> - <%= number2 %> = <%= number1 - number2 %>
        <br>
        <%= number1 %> x <%= number2 %> = <%= number1 * number2 %>
        <br>
        <%= number1 %> / <%= number2 %> = <%= number1 / number2 %>
        <br>
        
        <h2>EL 이용</h2>
        <%-- 
        EL에서 요청 파라미터 값을 찾는 방법:
          * ${ param.name }
          * ${ param['name'] }
        --%>
        ${ param.number1 } + ${ param.number2 } = ${ param.number1 + param.number2 }
        <br>
        ${ param['number1'] } - ${ param['number2'] } = ${ param['number1'] - param['number2'] }
        <br>
        ${ param.number1 } x ${ param.number2 } = ${ param.number1 * param.number2 }
        <br>
        ${ param.number1 } / ${ param.number2 } = ${ param.number1 / param.number2 }
        <br>
        
        <%-- scriptlet에서 선언한 변수(지역 변수)는 EL에서 사용할 수 없다. --%>
        
    </body>
</html>