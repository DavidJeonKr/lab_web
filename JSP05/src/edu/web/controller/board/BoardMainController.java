package edu.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;

// board/main 요청 주소를 처리할 Controller 클래스
public class BoardMainController implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 전체 목록을 검색한 결과를 View(JSP)에 전달.
		
		return "/WEB-INF/board/board-main.jsp";
	}

}