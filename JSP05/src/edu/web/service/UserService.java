package edu.web.service;

import java.util.List;

import edu.web.domain.User;

public interface UserService {
	
	List<User> select();
	
	int registerNewUser(User user);
	
	User select(String userid);
}
