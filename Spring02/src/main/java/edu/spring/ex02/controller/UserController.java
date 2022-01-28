package edu.spring.ex02.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.spring.ex02.domain.User;
import edu.spring.ex02.service.UserService;

@Controller  // servlet-context.xml의 <context:component-scan>에서 java bean으로 관리.
@RequestMapping(value = "/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired private UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register() {
		log.info("register() GET 호출");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user) {
		log.info("register({}) POST 호출", user);
		
		userService.registerNewUser(user);
		
		return "redirect:/";  // http://localhost:8181/ex02/ 으로 redirect
	}
	
	@RequestMapping(value = "/checkid", method = RequestMethod.POST)
	@ResponseBody
	// controller 메서드가 리턴하는 문자열이 jsp 파일 경로이거나 혹은 페이지 이동(forward, redirect) 주소가 아니라,
	// 클라이언트로 전송되는 응답(response) 문자열임을 선언하는 어노테이션.
	public String checkUserId(String userid) {
		log.info("checkUserId(userid={})", userid);
		
		if (userService.isValidId(userid)) {
			return "valid";
		} else {
			return "invalid";
		}
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void signIn() {
		log.info("signIn() GET 호출");	
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signIn(User user, HttpSession session) {
		log.info("signIn({}) POST 호출", user);
		
		User signInUserId = userService.checkSignIn(user);
		
		if(signInUserId != null) { // 아이디, 비밀번호가 일치하는 사용자 정보가 테이블에 있으면
			// 로그인 정보를 세션에 저장 -> 메인 페이지 이동
			session.setAttribute("signInUserId", signInUserId.getUserid());
			return "redirect:/";
			
		} else { // 아이디, 비밀번호 일치하는 사용자가 없으면
			// 로그인 실패 -> 로그인 페이지 다시 보여주기
			return "redirect:/user/signin";
		}
	}
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signOut(HttpSession session) {
		// 세션에 저장된 로그인 정보(로그인 사용자 아이디)를 제거 -> 메인 페이지 
		session.removeAttribute("signInUserId");
		session.invalidate();
		
		return "redirect:/";
	}

}