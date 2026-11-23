package com.office.diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DiaryDao {

    // ============================== [1] DB 접속 정보 시작 ================================
    // 아래 접속 정보는 H 정답 저장소의 값을 그대로 사용합니다.
    final private String DRIVER = "com.mysql.cj.jdbc.Driver";
    final private String URL = "jdbc:mysql://127.0.0.1:3306/db_diary";
    final private String USERNAME = "root";
    final private String PASSWORD = "1234";
    // ============================== [1] DB 접속 정보 끝 ==================================

    // ============================== [2] 일기 저장 메서드 시작 =============================
    // Service로부터 DiaryDto를 전달받아 MySQL tbl_diary 테이블에 저장합니다.
    public int insertNewDiary(DiaryDto diaryDto) {

        // INSERT 실행 결과(영향을 받은 행 수)를 저장할 변수입니다.
        int result = 0;

        // Connection: DB 연결 통로 / PreparedStatement: SQL 실행 객체
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // ------------------------------ [2-1] JDBC 드라이버 로드 시작 ------------------
            // MySQL JDBC 드라이버를 메모리에 로드합니다.
            Class.forName(DRIVER);
            // ------------------------------ [2-1] JDBC 드라이버 로드 끝 --------------------

            // ------------------------------ [2-2] DB 연결 시작 -----------------------------
            // URL, USERNAME, PASSWORD로 MySQL 연결을 생성합니다.
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // ------------------------------ [2-2] DB 연결 끝 -------------------------------

            // ------------------------------ [2-3] SQL 작성 시작 ----------------------------
            // tbl_diary 테이블의 diaryWord와 memId 컬럼에 값을 저장합니다.
            // 첫 번째 ?에는 일기 내용, 두 번째 ?에는 회원 ID가 들어갑니다.
            String sql = "insert into tbl_diary(diaryWord, memId) values(?, ?)";
            // ------------------------------ [2-3] SQL 작성 끝 ------------------------------

            // ------------------------------ [2-4] PreparedStatement 생성 시작 -------------
            // Connection을 통해 작성한 SQL을 실행할 PreparedStatement 객체를 만듭니다.
            pstmt = conn.prepareStatement(sql);
            // ------------------------------ [2-4] PreparedStatement 생성 끝 ----------------

            // ------------------------------ [2-5] DTO 데이터 주입 시작 ---------------------
            // DTO의 Getter로 값을 가져와 SQL의 물음표에 순서대로 설정합니다.
            pstmt.setString(1, diaryDto.getDiaryWord());
            pstmt.setString(2, diaryDto.getMemId());
            // ------------------------------ [2-5] DTO 데이터 주입 끝 -----------------------

            // ------------------------------ [2-6] SQL 실행 시작 ----------------------------
            // SQL과 파라미터는 위에서 준비했으므로 executeUpdate()로 실행합니다.
            // 반환되는 int는 SQL 실행으로 영향을 받은 행의 수입니다.
            result = pstmt.executeUpdate();
            // ------------------------------ [2-6] SQL 실행 끝 ------------------------------

            /*
             * executeQuery(): SELECT 실행, ResultSet 반환
             * executeUpdate(): INSERT, UPDATE, DELETE 실행, 영향받은 행 수(int) 반환
             */

        } catch (Exception e) {
            // 드라이버 로드, DB 연결, SQL 실행 중 예외가 발생하면 콘솔에 출력합니다.
            e.printStackTrace();

        } finally {
            // ============================== [3] 외부 자원 해제 시작 =======================
            // SQL 성공 여부와 관계없이 사용한 JDBC 자원을 닫습니다.
            try {
                // 나중에 생성한 PreparedStatement를 먼저 닫습니다.
                if (pstmt != null) pstmt.close();
                // 그다음 Connection을 닫아 DB 연결을 해제합니다.
                if (conn != null) conn.close();

            } catch (Exception e2) {
                e2.printStackTrace();
            }
            // ============================== [3] 외부 자원 해제 끝 =========================
        }

        // DB 저장 결과를 Service로 반환합니다.
        return result;
    }
    // ============================== [2] 일기 저장 메서드 끝 ===============================
}
