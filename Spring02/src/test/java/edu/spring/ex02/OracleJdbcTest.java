package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;

// JUnit 테스트
// 1) 테스트 클래스(OracleJdbcTest)를 실행시킬 메인 클래스를 설정.
@RunWith(SpringJUnit4ClassRunner.class)

// 2. 테스트를 실행하기 위해서 필요한 환경 설정 정보 파일들 (*-context.xml)의 위치.
// root-context.xml, appServlet/servlet-context.xml 파일을 검색
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)

// 3. 배포 관리자(deployment descriptor, web.xml)의 환경 설정 정보 사용.
@WebAppConfiguration
public class OracleJdbcTest {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	
	private static final Logger logger = LoggerFactory.getLogger(OracleJdbcTest.class);
	
	@Test
	public void doJunitTest() throws SQLException {
		logger.info("doJunitTest() 시작");
		
		//JDBC 1. JDBC 라이브러리를 메모리에 로딩.
		DriverManager.registerDriver(new OracleDriver());
		logger.info("Driver 로딩 성공");
		
		//JDBC 2. Connection 맺음.
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		logger.info("connection 성공: {}", conn);
		
		// Connection 끊기
		conn.close();
		logger.info("connection 해제 성공");
	}
}
