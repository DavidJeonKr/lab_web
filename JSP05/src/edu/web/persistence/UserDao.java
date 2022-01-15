package edu.web.persistence;

import static edu.web.domain.User.Entry.*;

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
	
}