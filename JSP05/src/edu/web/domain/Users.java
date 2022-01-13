package edu.web.domain;

public class Users {
	// DB의 테이블 이름, 컬럼 이름들을 상수로 정의 하고 있는 내부 클래스
	
	public static abstract class Entry {
		public static final String TABLE_USER = "USERS"; //테이블 이름
		public static final String COL_USERID = "USERID"; // 사용자 이름(primary key)
		public static final String COL_PWD = "PWD"; // 로그인 비밀번호
		public static final String COL_EMAIL = "EMAIL"; // 이메일
		public static final String COL_POINTS = "POINTS"; // 글/댓글 작성했을 떄 지급하는 포인트 정보
	}
	
	private String userid;
	private String pwd;
	private String email;
	private int points;
	
	public Users() {}

	public Users(String userid, String pwd, String email, int points) {
		super();
		this.userid = userid;
		this.pwd = pwd;
		this.email = email;
		this.points = points;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	};
}
