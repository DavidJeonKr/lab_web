package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import edu.web.domain.Board;

import static edu.web.domain.Board.Entry.*;
import static edu.web.persistence.BoardDao.*;

public class BoardDaoImpl implements BoardDao {

	// BoardDaoImpl 객체는 Connection Pool에서 Connection을 빌려서 SQL 쿼리를 실행.
	private DataSource ds;
	
	// Singleton 패턴 적용
	private static BoardDaoImpl instance = null;
	
	private BoardDaoImpl() {
		ds = DataSourceUtil.getDataSource();
	}
	
	public static BoardDaoImpl getInstance() {
		if (instance == null) {
			instance = new BoardDaoImpl();
		}
		return instance;
	}
	
	@Override
	public List<Board> read() {
		System.out.println("boardDaoImple.read() 메서드 호출");
		
		List<Board> list = new ArrayList<Board>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();  // Connection Pool에 있는 Connection 객체를 빌려옴.
			System.out.println(SQL_SELECT_ALL);
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);  // SQL 문장 작성
			rs = pstmt.executeQuery();  // DB로 SQL 문장을 전송, 실행, 결과 반환.
			while (rs.next()) { // ResultSet에 레코드(행)가 있으면
				// 레코드에서 각 컬럼에 있는 값들을 읽음.
				int bno = rs.getInt(COL_BNO);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String userid = rs.getString(COL_USERID);
				Date regDate = rs.getDate(COL_REG_DATE);
				int viewCnt = rs.getInt(COL_VIEW_CNT);
				int replyCnt = rs.getInt(COL_REPLY_CNT);
				String attachment = rs.getString(COL_ATTACH);
				
				// Board 객체 생성
				Board board = new Board(bno, title, content, userid, 
						regDate, viewCnt, replyCnt, attachment);
				// List에 추가
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}

}