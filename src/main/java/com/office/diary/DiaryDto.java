package com.office.diary;

public class DiaryDto {

	// only diary
	private int diaryNo;
	private String diaryword;
	private String diaryRegDate	;	
	private String diaryModDate;
	
	// only member
	private int memNo;
	private String memId;
	private String memPw;
	private String memMail;
	private String memPhone;
	private String memRegDate;
	private String memModDate;
	
	
	public DiaryDto() {
		// TODO Auto-generated constructor stub
	}


	public DiaryDto(int diaryNo, String diaryword, String memId, String diaryRegDate, String diaryModDate) {
		this.diaryNo = diaryNo;
		this.diaryword = diaryword;
		this.memId = memId;
		this.diaryRegDate = diaryRegDate;
		this.diaryModDate = diaryModDate;
	}
	
	public DiaryDto(String diaryword, String memId) {
		this.diaryword = diaryword;
		this.memId = memId;
		
	}


	public int getDiaryNo() {
		return diaryNo;
	}


	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}


	public String getDiaryword() {
		return diaryword;
	}


	public void setDiaryword(String diaryword) {
		this.diaryword = diaryword;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getDiaryRegDate() {
		return diaryRegDate;
	}


	public void setDiaryRegDate(String diaryRegDate) {
		this.diaryRegDate = diaryRegDate;
	}


	public String getDiaryModDate() {
		return diaryModDate;
	}


	public void setDiaryModDate(String diaryModDate) {
		this.diaryModDate = diaryModDate;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public String getMemPw() {
		return memPw;
	}


	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}


	public String getMemMail() {
		return memMail;
	}


	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}


	public String getMemPhone() {
		return memPhone;
	}


	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}


	public String getMemRegDate() {
		return memRegDate;
	}


	public void setMemRegDate(String memRegDate) {
		this.memRegDate = memRegDate;
	}


	public String getMemModDate() {
		return memModDate;
	}


	public void setMemModDate(String memModDate) {
		this.memModDate = memModDate;
	}
	
	
	
	
}
