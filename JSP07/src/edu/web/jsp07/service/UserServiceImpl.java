package edu.web.jsp07.service;

import edu.web.jsp07.model.User;
import edu.web.jsp07.persistence.UserDao;
import edu.web.jsp07.persistence.UserDaoImpl;

public class UserServiceImpl implements UserService{

	
	private UserDao userDao;
	
	private static UserServiceImpl instance = null;
	private UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
	}
	
	public static UserServiceImpl getInstance() {
		if(instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	@Override
	public boolean checkSignIn(String id, String pw) {
		User user = userDao.checkSignIn(id, pw);
		if(user != null) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
