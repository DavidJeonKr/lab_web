package edu.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.User;
import edu.web.service.UserService;
import edu.web.service.UserServiceImpl;

public class UserMainController implements Action {
	UserService userService = UserServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<User> list = userService.select();
		
		request.setAttribute("userList", list);
		
		return "/WEB-INF/user/user-main.jsp";
	}
	
	// 과제: 메인에서 만든 기능 
	//(1) users 테이블 전체검색 (select * from users)
	// 기능: 1.메인 페이지 돌아가기 2. 신규 회원 등록
	//(2) users 테이블 신규 회원 등록 (insert into users (...) values(...));
	// 기능: 1. 아이디, 패스워드, 이메일
	//(3) users 테이블 상세 보기 (select * from users where userId = ?); 
	// 기능: 아이디, 패스워드, 이메일, 포인트
	
	// 완전 기본적인 컴파일러.. basic 개념!!!!
	// jdbc 연결하는게
}
