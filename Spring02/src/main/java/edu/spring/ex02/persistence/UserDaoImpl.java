package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.User;
import edu.spring.ex02.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
	
	// mapper xml 파일을 사용할 때는 SqlSession 객체를 주입받음.
	// 어노테이션 방식의 인터페이스를 사용할 때는,
	// 스프링 컨테이너가 생성하고 관리하는 mapper 객체를 주입(injectcion)받음.
	@Autowired private UserMapper mapper;
	
	@Override
	public int create(User user) {
		log.info("create({}) 호출", user);
		
		return mapper.insert(user);
	}
	
	@Override
	public User checkUserId(String userid) {
		log.info("checkUserId(userid={}) 호출", userid);
		
		return mapper.selectByUserId(userid);
	}
	
	@Override
	public User read(User user) {
		log.info("read({}) 호출", user);
		return mapper.selectByIdAndPwd(user);
	}
	
	@Override
	public int updatePoints(String userid, int points) {
		log.info("updatePoints(userid={}, points={}) 호출", userid, points);
		
		Map<String, Object> params = new HashMap<>();
		params.put("userid", userid);
		params.put("points", points);
		
		return mapper.updateUserPoints(params);
	}
	
}