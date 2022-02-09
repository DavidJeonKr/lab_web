package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.persistence.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService {

	private static final Logger log = LoggerFactory.getLogger(ReplyServiceImpl.class);
	
	@Autowired
	private  ReplyDao replyDao;
	
	@Override
	public List<Reply> select(int bno) {
		log.info("select(bno={})", bno);
		
		return replyDao.read(bno);
	}

}