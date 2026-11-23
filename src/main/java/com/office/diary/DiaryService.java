package com.office.diary;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DiaryService {

    // Service가 사용할 DAO 객체를 필드에 보관합니다.
    final private DiaryDao diaryDao;

    // ============================== [1] 생성자 시작 ======================================
    // Controller가 생성한 DiaryDao 객체를 생성자로 전달받습니다.
    // 전달받은 DAO 참조를 this.diaryDao 필드에 저장합니다(생성자 주입).
    public DiaryService(DiaryDao diaryDao) {
        this.diaryDao = diaryDao;
    }
    // ============================== [1] 생성자 끝 ========================================

    // ============================== [2] 일기 작성 메서드 시작 =============================
    // Controller에서 받은 request 안의 입력값과 로그인 세션을 사용합니다.
    public int writeNewDiary(HttpServletRequest request, HttpServletResponse response) {

        // ------------------------------ [2-1] JSP 입력값 가져오기 시작 --------------------
        // write_form.jsp의 input name="diaryWord"와 이름이 정확히 일치해야 합니다.
        String diaryWord = request.getParameter("diaryWord");
        // ------------------------------ [2-1] JSP 입력값 가져오기 끝 ----------------------

        // ------------------------------ [2-2] 로그인 세션 가져오기 시작 ------------------
        // 현재 요청에 연결된 HttpSession 객체를 가져옵니다.
        HttpSession session = request.getSession();

        // MemberController가 로그인 성공 시 저장한 세션 속성 이름과 같아야 합니다.
        String signinedMemberId = String.valueOf(session.getAttribute("signinedMemberId"));
        // ------------------------------ [2-2] 로그인 세션 가져오기 끝 --------------------

        // ------------------------------ [2-3] DTO 객체 생성 시작 --------------------------
        // 일기 내용과 로그인 회원 ID를 하나의 DTO 객체에 담습니다.
        DiaryDto diaryDto = new DiaryDto(diaryWord, signinedMemberId);
        // ------------------------------ [2-3] DTO 객체 생성 끝 ----------------------------

        // ------------------------------ [2-4] DAO 호출 시작 -------------------------------
        // Service는 SQL을 직접 실행하지 않고 DAO에게 DB 저장을 맡깁니다.
        int result = diaryDao.insertNewDiary(diaryDto);
        // ------------------------------ [2-4] DAO 호출 끝 ---------------------------------

        // DAO가 반환한 저장 결과를 Controller에 다시 전달합니다.
        return result;
    }
    // ============================== [2] 일기 작성 메서드 끝 ===============================
}
