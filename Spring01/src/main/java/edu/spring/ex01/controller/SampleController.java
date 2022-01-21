package edu.spring.ex01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// POJO(Plain Old Java Object):
// 특정 클래스를 상속받거나 인터페이스를 구현하지 않는 일반적인 간단한 자바 클래스 
// Spring Framwork의 특징 중 하나는 POJO를 사용한다는 점

// @Controller: POJO를 controller 콤포넌트로 생성하도록 선언하는 어노테이션
// 어노테이션을 사용하려면 servlet-context.xml 파일에 컴포넌트 어노테이션들을 검색하는 태그가 설정되어 이써양 한다.
@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class); 
	
	@RequestMapping(value = {"sample1"}, method = {RequestMethod.GET})
	public String testSample1() {
		logger.info("testSample1() 호출");
		
		return "sample1";
	}
	
	@RequestMapping(value = "sample2", method = RequestMethod.GET)
	public void testSample2() {
		logger.info("testSample2() 호출");
	}
	
	// ViewResolver가 JSP 파일을 찾는 방법:
	// 1) controller 메서드가 문자열을 리턴하면, 리턴하는 문자열로 JSP 파일을 찾음.
	// 2) controller 메서드가 아무것도 리턴하지 않으면, 요청 주소로 JSP파일을 찾음.

}
