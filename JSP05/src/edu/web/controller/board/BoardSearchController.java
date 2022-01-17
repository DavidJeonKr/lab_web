package edu.web.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.Board;
import edu.web.service.BoardService;
import edu.web.service.BoardServiceImpl;

public class BoardSearchController implements Action {
	
	private BoardService boardService = BoardServiceImpl.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardSearchController.execute() 메서드 호출");
		
		// 요청 파라미터 type(검색 타입), keyword(검색어)을 읽음.
		int type = Integer.parseInt(request.getParameter("type"));
		String keyword = request.getParameter("keyword");
		
		// BoardService 객체의 메서드를 호출해서 검색 결과(List<Board>)를 받음.
		List<Board> list = boardService.select(type, keyword);
		
		// 검색 결과를 request에 포함시켜서 View로 포워드.
		request.setAttribute("boardList", list);
		
		return "/WEB-INF/board/board-main.jsp";
	}

}