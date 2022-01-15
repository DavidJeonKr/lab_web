package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDaoImpl implements UserDao {

	private DataSource ds;
	
	// singleton 패턴
	private static UserDaoImpl instance = null;
	
	private UserDaoImpl() {
		ds = DataSourceUtil.getDataSource();
	};
	
	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	@Override
	public int update(int points, String userId) {
		System.out.println("userDaoImple.update(" + points + ", " + userId + ") 메서드 호출");
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// Connection Pool에서 Connection 객체를 빌려옴.
			conn = ds.getConnection();
			
			// DB에서 실행할 SQL 문장을 완성
			pstmt = conn.prepareStatement(SQL_UPDATE_USER_POINTS);
			System.out.println(SQL_UPDATE_USER_POINTS);
			pstmt.setInt(1, points); // SQL의 첫번째 ?를 points(정수)로 대체.
			pstmt.setString(2, userId); // SQL의 두변째 ?를 userId(문자열)로 대체.
			
			// SQL 문장 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 리소스 반환 - Connection 객체를 Connection Pool로 반환.
			DataSourceUtil.close(conn, pstmt);
		}
		
		return result;
	}

}