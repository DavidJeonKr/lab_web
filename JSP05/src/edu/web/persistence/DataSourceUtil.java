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
// Connection pool(DataSource)에서 COnnection 객체를 가져옴.
// Connection pool(DataSource)에 Connection 객체를 반환(리소스 해제).
public class DataSourceUtil {
	
	// private 생성자 -> 객체 생성 불가능.
	private DataSourceUtil() {}
	
	public static DataSource getDataSource() {
//		System.out.println("DataSourceUtil.getDataSource() 메서드 호출");
		Context initContext;
		Context envContext;
		DataSource ds = null;
		try {
			// xml 파일(context 파일)을 찾을 수 찾기 위한 객체
			initContext = new InitialContext();
			//WAS(톰캣)가 가지고 있는 xml 파일(context 파일)을 찾음
			envContext = (Context) initContext.lookup("java:/comp/env");
			// 환경 설정 정보에 정의된 리소스(jdbc/myoracle)를 찾음.
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
//			System.out.println("DataSource: " + ds);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ds;
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}
}
