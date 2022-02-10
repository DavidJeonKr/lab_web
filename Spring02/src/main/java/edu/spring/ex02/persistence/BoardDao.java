package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.Board;

// CRUD(Create, Read, Update, Delete)
public interface BoardDao {
	
	List<Board> read();
	Board read(int bno);
	int create(Board board);
	int update(Board board);
	int updateViewCnt(int bno);
	int delete(int bno);
	List<Board> read(int type, String keyword);
	int updateReplyCnt(int bno, int increase);
	
}