package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.Board;

public interface BoardService {
	List<Board> select();

	int insert(Board board);

	Board select(int bno);

	int update(Board board);

	int delete(int bno);

	List<Board> select(int searchType, String searchKeyword);
	
}
