package edu.spring.ex02.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.ex02.domain.User;

@Mapper // 스프링 컨테이너에서 컴포넌트 객체(java bean)로 생성해서 관리하도록.
public interface UserMapper {

	// 회원 가입
	String SIGN_UP = 
			"INSERT INTO ${TABLE_USERS} (${COL_USERID}, ${COL_PWD}, ${COL_EMAIL}) "
			+ "VALUES (#{userid}, #{pwd}, #{email})";
	
	@Insert(SIGN_UP)
	int insert(User user);
	
	// 중복 아이디 체크
	String CHECK_USER_ID = 
			"SELECT * FROM ${TABLE_USERS} WHERE ${COL_USERID} = #{userid}";
	
	@Select(CHECK_USER_ID)
	User selectByUserId(String userid);
	
	// 로그인 아이디/비밀번호 비교
	String CHECK_SIGN_IN = 
			"SELECT * FROM ${TABLE_USERS} WHERE ${COL_USERID} = #{userid} AND ${COL_PWD} = #{pwd}";
	
	@Select(CHECK_SIGN_IN)
	User selectByIdAndPwd(User user);
	
	// 사용자 포인트 업데이트
	String UPDATE_USER_POINTS = 
			"UPDATE ${TABLE_USERS} SET ${COL_POINTS} = ${COL_POINTS} + #{points} "
			+ "WHERE ${COL_USERID} = #{userid}";
	
	@Update(UPDATE_USER_POINTS)
	int updateUserPoints(Object params);
	
}