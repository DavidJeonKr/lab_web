package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.persistence.BoardDao;
import edu.spring.ex02.persistence.ReplyDao;
import edu.spring.ex02.persistence.UserDao;

@Service
public class ReplyServiceImpl implements ReplyService {

	private static final Logger log = LoggerFactory.getLogger(ReplyServiceImpl.class);
	
	@Autowired private ReplyDao replyDao;
	@Autowired private BoardDao boardDao;
	@Autowired private UserDao userDao;
	
	@Override
	public List<Reply> select(int bno) {
		log.info("select(bno={})", bno);
		
		return replyDao.read(bno);
	}

	@Override
	public int insert(Reply reply) {
		// 댓글 테이블(replies)에 새로운 댓글 추가.
		int result = replyDao.create(reply);
		
		// 게시판 테이블(boards)에 댓글수를 업데이트.
		boardDao.updateReplyCnt(reply.getBno(), 1);
		
		// 댓글을 작성한 사용자에게 포인트 지급.
		userDao.updatePoints(reply.getUserid(), 5);
		
		return result;
	}
	
	@Override
	public int update(Reply reply) {
		log.info("update({})", reply);
		
		// 댓글 테이블(replies) 업데이트
		return replyDao.update(reply);
	}
	
	@Override
	public int delete(int rno) {
		log.info("delete(rno={})", rno);
		
		// 댓글 번호가 rno인 댓글의 게시글 번호(bno)를 찾음.
		int bno = replyDao.readBno(rno);
		
		// 댓글 테이블(replies)에서 rno의 댓글 삭제.
		int result = replyDao.delete(rno);
		
		// 댓글 삭제가 성공한 경우, 게시판 테이블(boards)에서 bno의 댓글수를 감소.
		boardDao.updateReplyCnt(bno, -1);
		
		return result;
	}
	
}