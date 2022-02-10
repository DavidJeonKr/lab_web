package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.Board;

@Repository // 스프링 프레임워크에게 영속 계층(persistence layer)의 컴포넌트(DAO)임을 알려주는 어노테이션.
// root-context.xml 파일에서 <context:component-scan>에 의해서 Java bean이 생성, 관리됨.
public class BoardDaoImpl implements BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	private static final String BOARD_NAMESPACE = "edu.spring.ex02.mapper.BoardMapper";

	// root-context.xml로 관리되고 있는 Java bean 객체를 주입(injection)받음.
	@Autowired private SqlSession sqlSession;
	
	@Override
	public List<Board> read() {
		logger.info("boardDaoImpl.read() 호출");
		
		return sqlSession.selectList(BOARD_NAMESPACE + ".selectAll");
	}
	
	@Override
	public Board read(int bno) {
		logger.info("boardDaoImpl.read(bno={}) 호출", bno);
		
		return sqlSession.selectOne(BOARD_NAMESPACE + ".selectByBno", bno);
	}
	
	@Override
	public int create(Board board) {
		logger.info("boardDaoImpl.create({}) 호출", board);
		
		return sqlSession.insert(BOARD_NAMESPACE + ".create", board);
	}
	
	@Override
	public int update(Board board) {
		logger.info("boardDaoImpl.update({}) 호출", board);
		
		return sqlSession.update(BOARD_NAMESPACE + ".update", board);
	}
	
	@Override
	public int updateViewCnt(int bno) {
		logger.info("boardDaoImpl.updateViewCnt(bno={}) 호출", bno);
		
		return sqlSession.update(BOARD_NAMESPACE + ".updateViewCnt", bno);
	}
	
	@Override
	public int delete(int bno) {
		logger.info("boardDaoImpl.delete(bno={})", bno);
		
		return sqlSession.delete(BOARD_NAMESPACE + ".delete", bno);
	}
	
	@Override
	public List<Board> read(int type, String keyword) {
		logger.info("boardDaoImpl.read(type={}, keyword={})", type, keyword);
		
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		params.put("keyword", "%" + keyword.toLowerCase() + "%");
		
		return sqlSession.selectList(BOARD_NAMESPACE + ".selectByKeyword", params);
	}
	
	@Override
	public int updateReplyCnt(int bno, int increase) {
		logger.info("updateReplyCnt(bno={}, increase={}) 호출", bno, increase);
		
		Map<String, Object> params = new HashMap<>();
		params.put("bno", bno);
		params.put("increase", increase);
		
		return sqlSession.update(BOARD_NAMESPACE + ".updateReplyCnt", params);
	}
	
}