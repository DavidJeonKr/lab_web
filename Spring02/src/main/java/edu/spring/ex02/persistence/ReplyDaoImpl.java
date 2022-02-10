package edu.spring.ex02.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	private static final Logger log = LoggerFactory.getLogger(ReplyDaoImpl.class);
	private static final String NAMESPACE = "edu.spring.ex02.mapper.ReplyMapper";
	
	@Autowired  // 의존성 주입
	private SqlSession sqlSession;
	
	@Override
	public int create(Reply reply) {
		log.info("create({}) 호출", reply);
		
		return sqlSession.insert(NAMESPACE + ".insert", reply);
	}

	@Override
	public List<Reply> read(int bno) {
		log.info("read(bno={}) 호출", bno);
		
		return sqlSession.selectList(NAMESPACE + ".select", bno);
	}
	
	@Override
	public int update(Reply reply) {
		log.info("update({}) 호출", reply);
		
		return sqlSession.update(NAMESPACE + ".update", reply);
	}
	
	@Override
	public int delete(int rno) {
		log.info("delete(rno={}) 호출", rno);
		
		return sqlSession.delete(NAMESPACE + ".delete", rno);
	}
	
	@Override
	public int readBno(int rno) {
		log.info("readBno(rno={})", rno);
		
		return sqlSession.selectOne(NAMESPACE + ".readBno", rno);
	}
	
}