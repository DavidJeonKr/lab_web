package edu.spring.ex02.service;

import edu.spring.ex02.domain.User;

public interface UserService {
	
	int registerNewUser(User user);
	
	boolean isValidId(String userid);

	User checkSignIn(User user);
	
}
