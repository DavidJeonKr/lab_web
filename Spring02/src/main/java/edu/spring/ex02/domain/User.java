package edu.spring.ex02.domain;

public class User {
	private String userid;
	private String pwd;
	private String email;
	private int points;
	
	public User() {}

	public User(String userid, String pwd, String email, int points) {
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
	}
	
	@Override
	public String toString() {
		return String.format(
				"User{userid=%s, pwd=%s, email=%s, points=%d}", 
				this.userid, this.pwd, this.email, this.points);
	}
	
}