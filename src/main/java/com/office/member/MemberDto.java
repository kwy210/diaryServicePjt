package com.office.member;

public class MemberDto {

	private int memNo;
	private String memId;
	private String memPw;
	private String memMail;
	private String memPhone;
	private String memRegDate;
	private String memModDate;
	
	public MemberDto() {}

	public MemberDto(int memNo, String memId, String memPw, String memMail, String memPhone, String memRegDate,
			String memModDate) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memPw = memPw;
		this.memMail = memMail;
		this.memPhone = memPhone;
		this.memRegDate = memRegDate;
		this.memModDate = memModDate;
	}

	public MemberDto(int memNo, String memId, String memPw, String memMail) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memPw = memPw;
		this.memMail = memMail;
		this.memPhone = memPhone;
		
	}

	
}
