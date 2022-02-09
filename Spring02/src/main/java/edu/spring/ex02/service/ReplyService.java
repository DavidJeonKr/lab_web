package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.Reply;

public interface ReplyService {
	
	List<Reply> select(int bno);

}