package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.persistence.BoardDao;

@Service // 스프링 컨테이너(프레임워크)가 서비스 컴포넌트로 생성하고 관리하기 위해서.
public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> select() {
		log.info("select() 호출");

		return boardDao.read();
	}

	@Override
	public int insert(Board board) {
		log.info("insert({}) 호출", board);

		// TODO:
		// (1) board 테이블 새 글 insert.
		int result = boardDao.create(board);
		// (2) 글의 작성한 사용자의 points를 10 증가

		return result;
	}

	@Override
	public Board select(int bno) {

		// TODO:
		// (1) board 상세 페이지
		Board board = boardDao.read(bno);
		if (board != null) {
			boardDao.updateViewCnt(bno);
		}
		// (2) 글 보면 글 뷰카운트 1증가
		return board;
	}

	@Override
	public int update(Board board) {

		boardDao.update(board);
		return 0;
	}

	@Override
	public int delete(int bno) {
		
		return boardDao.delete(bno);
	}
}
