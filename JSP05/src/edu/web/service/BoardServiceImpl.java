package edu.web.service;

import java.util.List;

import edu.web.domain.Board;
import edu.web.persistence.BoardDao;
import edu.web.persistence.BoardDaoImpl;

public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao;
	
	// Singleton 패턴 적용
	private static BoardServiceImpl instance = null;
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	};
	public static  BoardServiceImpl getInstance() {
		if(instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<Board> select() {
		System.out.println("boardServiceImpl.select() 메서드 호출");
		return boardDao.read();
	}

}
