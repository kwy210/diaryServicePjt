package com.office.diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DiaryDao {

    
    
    final private String DRIVER = "com.mysql.cj.jdbc.Driver";
    final private String URL = "jdbc:mysql://127.0.0.1:3306/db_diary";
    final private String USERNAME = "root";
    final private String PASSWORD = "1234";
    
    // Service로부터 DiaryDto를 전달받아 MySQL tbl_diary 테이블에 저장합니다.
    public int insertNewDiary(DiaryDto diaryDto) {

        // INSERT 실행 결과(영향을 받은 행 수)를 저장할 변수입니다.
        int result = 0;

        // Connection: DB 연결 통로 / PreparedStatement: SQL 실행 객체
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            // MySQL JDBC 드라이버를 메모리에 로드합니다.
            Class.forName(DRIVER);
           
            
            // URL, USERNAME, PASSWORD로 MySQL 연결을 생성합니다.
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            
            // tbl_diary 테이블의 diaryWord와 memId 컬럼에 값을 저장합니다.
            // 첫 번째 ?에는 일기 내용, 두 번째 ?에는 회원 ID가 들어갑니다.
            String sql = "insert into tbl_diary(diaryWord, memId) values(?, ?)";
            
            
            // Connection을 통해 작성한 SQL을 실행할 PreparedStatement 객체를 만듭니다.
            pstmt = conn.prepareStatement(sql);
           
            
            // DTO의 Getter로 값을 가져와 SQL의 물음표에 순서대로 설정합니다.
            pstmt.setString(1, diaryDto.getDiaryWord());
            pstmt.setString(2, diaryDto.getMemId());
            
            
            // SQL과 파라미터는 위에서 준비했으므로 executeUpdate()로 실행합니다.
            // 반환되는 int는 SQL 실행으로 영향을 받은 행의 수입니다.
            result = pstmt.executeUpdate();
           
            /*
             * executeQuery(): SELECT 실행, ResultSet 반환
             * executeUpdate(): INSERT, UPDATE, DELETE 실행, 영향받은 행 수(int) 반환
             */

        } catch (Exception e) {
            // 드라이버 로드, DB 연결, SQL 실행 중 예외가 발생하면 콘솔에 출력합니다.
            e.printStackTrace();

        } finally {
          
            try {
                // 나중에 생성한 PreparedStatement를 먼저 닫습니다.
                if (pstmt != null) pstmt.close();
                // 그다음 Connection을 닫아 DB 연결을 해제합니다.
                if (conn != null) conn.close();

            } catch (Exception e2) {
                e2.printStackTrace();
            }
            
        }

        // DB 저장 결과를 Service로 반환합니다.
        return result;
    }

	public List<DiaryDto> selectDiariesByMemId(String signInedMemberId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DiaryDto> diaryDtos = new ArrayList<DiaryDto>();
		try {
			// 1. 드라이버 로드 in 메모리
			Class.forName(DRIVER);
			
			// 2. 다리 건설: Connection 생성 by 인증(Authentication)
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// 3. SQL 작성(작업 지시서)
			String sql =  "select * from tbl_diary td "
						+ "join tbl_member tm "
						+ "on td.memId = tm.memId "
						+ "where td.memId = ?";
			
			// 4. 일꾼 선택(생성)
			pstmt = conn.prepareStatement(sql);
			
			// 5. 데이터 주입
			pstmt.setString(1, signInedMemberId);
			
			// 6. 작업 지시
			rs = pstmt.executeQuery();
			
			/*
			 * executeQuery(): select, 반환형(ResultSet) -> while문으로 사용하자
			 * executeUpdate(): insert, update, delete, 반환형(int) -> 영향을 받은 행 수
			 */
			
			while (rs.next()) {
				int diaryNo = rs.getInt("diaryNo");
				String diaryWord = rs.getString("diaryWord");
				String memId = rs.getString("memId");
				String diaryRegDate = rs.getString("diaryRegDate");
				String diaryModDate = rs.getString("diaryModDate");
				int memNo = rs.getInt("memNo");
				String memPw = rs.getString("memPw");
				String memMail = rs.getString("memMail");
				String memPhone = rs.getString("memPhone");
				String memRegDate = rs.getString("memRegDate");
				String memModDate = rs.getString("memModDate");
				
				DiaryDto diaryDto = new DiaryDto();
				
				diaryDto.setDiaryNo(diaryNo);
				diaryDto.setDiaryWord(diaryWord);
				diaryDto.setDiaryRegDate(diaryRegDate);
				diaryDto.setDiaryModDate(diaryModDate);
				
				diaryDto.setMemNo(memNo);
				diaryDto.setMemId(memId);
				diaryDto.setMemPw(memPw);
				diaryDto.setMemMail(memMail);
				diaryDto.setMemPhone(memPhone);
				diaryDto.setMemRegDate(memRegDate);
				diaryDto.setMemModDate(memModDate);
				
				diaryDtos.add(diaryDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			//8. 외부 자원 해제
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}

		}

		return diaryDtos;
		
	}

	}
   

