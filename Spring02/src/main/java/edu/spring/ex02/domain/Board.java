package edu.spring.ex02.domain;

import java.util.Date;

// MVC 디자인 패턴에서 Model에 해당하는 클래스.
// 멤버 변수(필드, 프로퍼티)들의 이름은 데이터베이스 테이블의 컬럼 이름과 일치.
// -> MyBatis 프레임워크에서 getter/setter를 찾을 때 테이블의 컬럼 이름을 기준으로 찾기 때문에.
public class Board {
	private int bno;
	private String title;
	private String content;
	private String userid;
	private Date reg_date;
	private int view_cnt;
	private int reply_cnt;
	private String attachment;
	
	public Board() {}

	public Board(int bno, String title, String content, String userid, 
			Date reg_date, int view_cnt, int reply_cnt, String attachment) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.reg_date = reg_date;
		this.view_cnt = view_cnt;
		this.reply_cnt = reply_cnt;
		this.attachment = attachment;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public int getReply_cnt() {
		return reply_cnt;
	}

	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return String.format(
				"Board{bno:%d, title:%s, content:%s, userid:%s, reg_date:%s, view_cnt:%d, reply_cnt:%d}", 
				this.bno, this.title, this.content, this.userid, 
				this.reg_date, this.view_cnt, this.reply_cnt);
	}

}