package edu.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.service.BoardService;
import edu.web.service.BoardServiceImpl;

public class BoardDeleteController implements Action {
	BoardService boardService = BoardServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int result = boardService.delete(bno);
		
		return REDIRECT_PREFIX+"main";
	}

}
