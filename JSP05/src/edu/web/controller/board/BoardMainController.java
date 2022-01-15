package edu.web.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.Board;
import edu.web.service.BoardService;
import edu.web.service.BoardServiceImpl;

// board/main 요청 주소를 처리할 Controller 클래스
public class BoardMainController implements Action {
	
	BoardService boardService = BoardServiceImpl.getInstance();
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardMainController.execute() 메서드 호출");
		
		// 서비스 계층의 메서드를 호출해서 게시글 전체목록을  검색.
		List<Board> list = boardService.select();
		
		// 게시글 전체 목록을 View(JSP)에게 전달하기 위해서 request 객체에 속성값으로 저장.
		// JSP로 포워드될 때는 request 객체가 유지되기 때문에, JSP에서 EL을 사용할 수 있다.
		request.setAttribute("boardList", list);
		
		return "/WEB-INF/board/board-main.jsp";
	}

}