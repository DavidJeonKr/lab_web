package edu.web.service;

import java.util.List;

import edu.web.domain.User;
import edu.web.persistence.UserDao;
import edu.web.persistence.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	private static UserServiceImpl instance = null;
	private UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
	};
	
	public static UserServiceImpl getInstance() {
		if(instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<User> select() {
		return userDao.read();
	}

	@Override
	public int registerNewUser(User user) {
		int result = 0;
		result = userDao.create(user);
		if(result == 1) {
			
		}
		return result;
	}

	@Override
	public User select(String userid) {
		User user = userDao.read(userid);
		
		
		return user;
	}

}
