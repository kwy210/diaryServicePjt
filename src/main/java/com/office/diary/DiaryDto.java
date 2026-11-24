package com.office.diary;

public class DiaryDto {

    
    // 일기 테이블(tbl_diary)의 데이터를 보관하는 필드입니다.
    private int diaryNo;
    private String diaryWord;
    private String diaryRegDate;
    private String diaryModDate;
   
    // 일기를 작성한 회원의 정보를 보관하는 필드입니다.
    // 이번 일기 작성(INSERT)에서는 memId를 사용합니다.
    private int memNo;
    private String memId;
    private String memPw;
    private String memMail;
    private String memPhone;
    private String memRegDate;
    private String memModDate;
    
    // 매개변수 없이 DiaryDto 객체를 생성할 때 사용합니다.
    public DiaryDto() { }
    
    // 조회한 일기 정보를 객체 생성과 동시에 필드에 저장할 때 사용하는 생성자입니다.
    public DiaryDto(int diaryNo, String diaryWord, String memId, String diaryRegDate, String diaryModDate) {
        this.diaryNo = diaryNo;
        this.diaryWord = diaryWord;
        this.memId = memId;
        this.diaryRegDate = diaryRegDate;
        this.diaryModDate = diaryModDate;
    }
    
    // 새 일기를 저장할 때 필요한 일기 내용과 회원 ID를 전달받습니다.
    // DiaryService에서 new DiaryDto(diaryWord, signinedMemberId)로 호출합니다.
    public DiaryDto(String diaryWord, String memId) {
        this.diaryWord = diaryWord;
        this.memId = memId;
    }
   
    // Getter: 다른 객체가 DTO 내부에 저장된 값을 가져갈 수 있게 합니다.
    // Setter: 다른 객체가 DTO 내부의 값을 변경할 수 있게 합니다.
    public int getDiaryNo() {
        return diaryNo;
    }

    public void setDiaryNo(int diaryNo) {
        this.diaryNo = diaryNo;
    }

    public String getDiaryWord() {
        return diaryWord;
    }

    public void setDiaryWord(String diaryWord) {
        this.diaryWord = diaryWord;
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
