<%@ page import="edu.web.model.Member"%>
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
        <h1>Java Beans</h1>
        <%-- 
        Java Bean: 자바 클래스 객체
          * 기본 생성자(default constructor)를 가지고 있어야 함.
          * 멤버 변수들은 private으로 선언.
          * public으로 선언된 getter/setter 메서드들이 있어야 함. (메서들 이름은 Java 코딩 관습에 따라야 함.)
        --%>
        
        <h2>scriptlet, expression을 이용한 자바 객체 사용</h2>
        <% // sciptlet
        Member m1 = new Member();  // 기본 생성자를 호출해서 객체 생성
        // setter 메서드 호출, 멤버 변수들의 값을 설정.
        m1.setMemberId("guest");
        m1.setMemberPassword("guest");
        m1.setMemberEmail("guest@test.com");
        %>
        <div>
        	<%-- expression 안에서 getter 메서드 호출, 멤버 변수들의 값을 출력. --%>
        	아이디: <%= m1.getMemberId() %> <br>
        	비밀번호: <%= m1.getMemberPassword() %> <br>
        	이메일: <%= m1.getMemberEmail() %> <br>
        </div>
        
        <h2>JSP 표준 액션 태그를 이용한 자바 객체 사용</h2>
        <jsp:useBean id="m2" class="edu.web.model.Member"></jsp:useBean>
        <%-- Member m2 = new Member(); 와 동일한 내용. --%>
        
        <jsp:setProperty property="memberId" name="m2" value="admin"/>
        <%-- m2.setMemberId("admin"); 와 동일한 내용. --%>

		<jsp:setProperty property="memberPassword" name="m2" value="1234"/>
		<jsp:setProperty property="memberEmail" name="m2" value="admin@itwill.co.kr"/>

		<div>
			아이디: <jsp:getProperty property="memberId" name="m2"/> <br>
			<%-- <%= m2.getMemberId() %>와 동일. --%>
			
			비밀번호: <jsp:getProperty property="memberPassword" name="m2"/> <br>
			이메일: <jsp:getProperty property="memberEmail" name="m2"/> <br>
		</div>

    </body>
</html>