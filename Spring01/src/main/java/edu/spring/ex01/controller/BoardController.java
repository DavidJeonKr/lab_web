package edu.spring.ex01.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value = {"/main"}, method = RequestMethod.GET)
	public void boardMain() {
		logger.info("boardMain() 호출");
	}
	
	@RequestMapping(value = {"/insert"}, method = RequestMethod.GET)
	public void boardInsert() {
		logger.info("boardInsert() 호출");
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String boardInsertPost(int bno, String title) {
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		String title = request.getParameter("title");
		
		
		logger.info("boardInsertPost() 호출: bno = {}, title = {}", bno, title);
		return "/board/insert-result";
	}
	
}
