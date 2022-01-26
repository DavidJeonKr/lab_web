package edu.spring.ex02.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.persistence.BoardDao;

@Service //스프링 컨테이너(프레임워크)가 서비스 컴포넌트로 생성하고 관리하기 위해서.
public class BoardServiceImpl implements BoardService{
	
	@Autowired private BoardDao boardDao;
	@Override
	public List<Board> select() {
		
	
		return boardDao.read();
	}

}
