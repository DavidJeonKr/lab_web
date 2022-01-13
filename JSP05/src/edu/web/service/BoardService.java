package edu.web.service;

import java.util.List;

import edu.web.domain.Board;

public interface BoardService {
	
	
	/**
	 * Persistence 계층(BoardDao)의 read 메서드를 호출해서 게시글 전체 목록을 반환하는 메서드. 
	 * @return Board를 원소로 갖는 Arraylist
	 */
	
	List<Board> select();
}
