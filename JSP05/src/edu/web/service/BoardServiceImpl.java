package edu.web.service;

import java.util.List;

import edu.web.domain.Board;
import edu.web.persistence.BoardDao;
import edu.web.persistence.BoardDaoImpl;
import edu.web.persistence.UserDao;
import edu.web.persistence.UserDaoImpl;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao;
	private UserDao userDao;
	
	// Singleton 패턴 적용
	private static BoardServiceImpl instance = null;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
		userDao = UserDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if (instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<Board> select() {
		System.out.println("boardServiceImple.select() 메서드 호출");
		return boardDao.read();
	}

	@Override
	public int registerNewBoard(Board board) {
		System.out.println("boardServiceImpl.registerNewBoard(board) 메서드 호출");
		
		int result = 0;
		
		// (1) boardDao의 메서드를 사용해서 boards 테이블에 새 글을 입력(insert).
		result = boardDao.create(board);
		// (2) userDao의 메서드를 사용해서 users 테이블의 해당 userId의 points를 10 증가.
		if (result == 1) { // boards 테이블에 insert 성공하면
			result = userDao.update(10, board.getUserId());
			// FIXME: 만약 insert 성공 후 update 실패하면 insert를 rollback.
		}
		
		return result;
	}

	@Override
	public Board select(int bno) {
		System.out.println("boardServiceImpl.select(bno=" + bno + ") 메서드 호출");
		
		Board board = boardDao.read(bno); // 글 번호로 게시글 검색
		if (board != null) { // 검색 결과가 있을 때
			int result = boardDao.update(bno); // 글 번호의 조회수를 1 증가
		}
		
		return board;
	}

	@Override
	public int update(Board board) {
		System.out.println("boardServiceImpl.update(board) 메서드 호출");
		
		return boardDao.update(board);
	}

	@Override
	public int delete(int bno) {
		System.out.println("boardServiceImpl.delete(bno=" + bno + ") 메서드 호출");
		
		return boardDao.delete(bno);
	}

	@Override
	public List<Board> select(int type, String keyword) {
		System.out.println("boardServiceImpl.select(type=" + type + ", keyword=" + keyword + ") 메서드 호출");
		
		return boardDao.read(type, keyword);
	}

}