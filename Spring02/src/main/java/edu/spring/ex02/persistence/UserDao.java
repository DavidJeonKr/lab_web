package edu.spring.ex02.persistence;

import edu.spring.ex02.domain.User;

public interface UserDao {
	
	int create(User user);
	User checkUserId(String userid);
	User read(User user);
	int updatePoints(String userid, int points);
	
}