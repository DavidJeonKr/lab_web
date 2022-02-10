package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.Reply;

public interface ReplyDao {
	
	int create(Reply reply);
	List<Reply> read(int bno);
	int update(Reply reply);
	int delete(int rno);
	int readBno(int rno);

}