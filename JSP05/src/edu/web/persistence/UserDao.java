package edu.web.persistence;

import static edu.web.domain.User.Entry.*;

import java.util.List;

import edu.web.domain.User;

public interface UserDao {

	// update USERS set POINTS = POINTS + ? where USERID = ?;
	String SQL_UPDATE_USER_POINTS = String.format(
			"update %s set %s = %s + ? where %s = ?", 
			TABLE_USER, COL_POINTS, COL_POINTS, COL_USERID);
	/**
	 * DB users 테이블에서 userId의 points 컬럼 값을 증가.
	 * 
	 * @param points 증가시킬 값.
	 * @param userId 수정할 userid(테이블의 고유키)
	 * @return
	 */
	int update(int points, String userId);
	
	String SQL_SELECT_ALL = String.format("select * from %s", 
			TABLE_USER);
	List<User> read();
	
	// insert into users(%s) (userid, pwd, email) values(?,?,?)
	String SQL_INSERT_USER =String.format("insert into %s (%s,%s,%s) values(?, ?, ?)", 
			TABLE_USER,COL_USERID,COL_PWD,COL_EMAIL);
	int create(User user);
	
	// select * from users where userid = ?;
	String SQL_SELECT_BY_USERID = String.format("select * from %s where %s = ?",
			TABLE_USER,COL_USERID);
	User read(String userid);
	
	
}