package edu.spring.ex01.domain;

public class Board {
	private int bno;
	private String title;
	private String userid;
	
	public Board() {}

	public Board(int bno, String title, String userid) {
		this.bno = bno;
		this.title = title;
		this.userid = userid;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return String.format("Board{bno: %d, title: %s, userid: %s}", this.bno, this.title, this.userid);
	}
	
	
}
