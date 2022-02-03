package edu.spring.ex02.domain;

import java.util.Date;

// 댓글 테이블 내용 - MVC 아키텍쳐에서 Model
public class Reply {
	private int rno; // 테이블 PK. Oracle sequence 사용.
	private String rtext; // 댓글 내용.
	private String userid; // 댓글 작성자 아이디. users 테이블을 찾아가는 FK.
	private Date regdate; // 작성 시간.
	private int bno; // 몇 번 글에 대한 댓글인 지. boards 테이블을 찾아가는 FK.
	
	public Reply() {}

	public Reply(int rno, String rtext, String userid, Date regdate, int bno) {
		this.rno = rno;
		this.rtext = rtext;
		this.userid = userid;
		this.regdate = regdate;
		this.bno = bno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRtext() {
		return rtext;
	}

	public void setRtext(String rtext) {
		this.rtext = rtext;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Reply{rno:%d, rtext:%s, userid:%s, regdate:%s, bno:%d}", 
				this.rno, this.rtext, this.userid, this.regdate, this.bno);
	}
}