package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.Board;

// CRUD(Create, Read, Update, Delete)
public interface BoardDao {
	
	//selectAll
	public List<Board> read();
	//selectByOne
	Board read(int bno);
	//insert
	int creat(Board board); // board.getTitle(), board.getContent(), board.getUserid()
	//update
	int update(int bno);
	//발표 자료 누구랑 누구
	// 언제까지는 자료조사, 개발을 하고, 등등
	//update viewcount
	int updateView(int bno);
	
	
	//delete
	int delte(int bno);

}