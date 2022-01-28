package edu.spring.ex02.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.User;
import edu.spring.ex02.persistence.UserDao;

@Service //Service 컴포넌트임을 선언 -> root-context.xml 설정에 의해서 bean으로 관리됨
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	// repository(persistence) 계층의 객체 사용
	@Autowired private UserDao userDao;
	
	@Override
	public int registerNewUser(User user) {
		log.info("registerNewUser({}) 호출", user);
		return userDao.create(user);
	}
	
	@Override
	public boolean isValidId(String userid) {
		log.info("isValidId(userid= {}) 호출", userid);
		
		User user = userDao.checkUserId(userid);
		if(user == null) { // DB 테이블에 해당 userid가 없는 경우 -> 가입 가능한 아이디
			return true;
		} else {
			return false;
		}
		
		
	}
	
	@Override
	public User checkSignIn(User user) {
		log.info("checkSignIn({}) 호출", user);
		return userDao.read(user);
	}

}
