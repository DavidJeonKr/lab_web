package edu.web.persistence;

import static edu.web.domain.Board.Entry.*;

import java.util.List;

import edu.web.domain.Board;

// CRUD(Create/Read/Update/Delete)
public interface BoardDao {
	
	String SQL_SELECT_ALL = String.format(
			"select * from %s order by %s desc", TABLE_BOARD, COL_BNO);
	
	/**
	 * DB BOARDS 테이블에서 전체 검색 결과를 리턴하는 메서드
	 * 
	 * @return Board 객체를 원소로 갖는 ArrayList.
	 */
	List<Board> read(); 
	
}
