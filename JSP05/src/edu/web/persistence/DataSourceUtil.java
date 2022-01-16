package edu.web.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// 인스턴스를 생성하지 않고, 모든 메서드를 static으로 작성한 유틸리티 클래스.
// Connection Pool(DataSource) 객체를 찾음.
// Connection Pool(DataSource)에 Connection 객체를 반환(리소스 해제).
public class DataSourceUtil {

	// private 생성자 -> 객체 생성 불가능.
	private DataSourceUtil() {}
	
	public static DataSource getDataSource() {
//		System.out.println("DataSourceUtil.getDataSource() 메서드 호출");
		
		Context initContext;
		Context envContext;
		DataSource ds = null;
		try {
			// xml 파일(컨텍스트 파일)을 찾기 위한 객체를 생성.
			initContext = new InitialContext();
			
			// WAS(톰캣)가 가지고 있는 xml 파일(컨텍스트 파일)을 찾음.
			envContext = (Context) initContext.lookup("java:/comp/env");
			
			// 환경 설정 정보에 정의된 리소스(jdbc/myoracle)를 찾음.
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
//			System.out.println("DataSource: " + ds);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
	public static void close(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		close(conn, stmt);
	}
	
}