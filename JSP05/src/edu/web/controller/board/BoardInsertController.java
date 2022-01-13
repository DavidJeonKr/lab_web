package edu.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;

//board/insert 요청(Get, Post)을 처리하는 controller
public class BoardInsertController implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardInsertController.execute() 메서드 호출");
		
		// TODO: 요청 방식을 알아냄  
		String method = request.getMethod();
		if(method.equals("GET")) {
			return doGet(request, response);
		} else {
			return doPost(request, response);
		}
//		return "/WEB-INF/board/board-insert.jsp";
	}


	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardInsertController.doGet() 메서드 호출");
		return "/WEB-INF/board/board-insert.jsp";
	}

	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardInserController.doPost() 메서드 호출");
		// TODO: BoardService의 메서드를 사용해서 작성된 글을 DB에 insert한 후,
		// 게시판 메인 페이지로 이동
		
		return REDIRECT_PREFIX + "main";
	}
}
