package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.Reply;

public interface ReplyService {
	
	List<Reply> select(int bno);
	int insert(Reply reply);
	int update(Reply reply);
	int delete(int rno);

}