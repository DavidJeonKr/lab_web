package edu.spring.ex02;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.persistence.ReplyDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
)
@WebAppConfiguration
public class ReplyDaoTest {

	private static final Logger log = LoggerFactory.getLogger(ReplyDaoTest.class);
	
	@Autowired
	private ReplyDao replyDao;
	
	@Test
	public void doTest() {
		log.info("replyDao: {}", replyDao);
		
		
//		Reply reply = new Reply(0, "DAO 테스트 2", "admin", null, 2);
//		int result = replyDao.create(reply);
//		log.info("insert result: {}", result);
		
		
		
		List<Reply> replyList = replyDao.read(1);
		log.info(replyList.toString());
		
		
		/*
		Reply reply = new Reply(1, "댓글 수정 테스트", null, null, 0);
		int result = replyDao.update(reply);
		log.info("update result: {}", result);
		*/
		
//		int result = replyDao.delete(1);
//		log.info("delete result: {}", result);
	}
	
}