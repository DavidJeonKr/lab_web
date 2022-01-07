package edu.web.model;

public class Member {
	// 멤버 변수(필드, 프로퍼티)
	protected String memberId;
	protected String memberPassword;
	protected String memberEmail;
	
	// 생성자
	public Member(String memberId, String memberPassword, String memberEmail) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
	}
	public Member() {};
	
	// getters, setters
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberPassword() {
		return memberPassword;
	}
	
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}
	
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	@Override
	public String toString() {
		return String.format("Member{memberId: %s, memberPassword: %s, memberEmail: %s}", 
				this.memberId, this.memberPassword, this.memberEmail);
	}
	
	
}
