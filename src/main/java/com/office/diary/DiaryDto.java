package com.office.diary;

public class DiaryDto {

	private int diaryNo;
	private String diaryword;
	private String memId;
	private String diaryRegDate	;	
	private String diaryModDate;

	
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
	
	
	
	
}
