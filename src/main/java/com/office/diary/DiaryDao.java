package com.office.diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.office.member.MemberDto;

public class DiaryDao {

	final private String DRIVER = "com.mysql.cj.jdbc.Driver";
	final private String URL = "jdbc:mysql://127.0.0.1:3306/db_diary";
	final private String UESNAME = "root";
	final private String PASSWORD = "1234";
	
	public int insertNewDiary(String diaryWrod) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. 드라이버 로드 in 메모리
			Class.forName(DRIVER); // 드라이버 로드 처음에는 오류 뜰수 있다, 그러면 예외처리 해야함

			// 2. 다리 건설: Connection 생성 by 인증(Authentication)
			conn = DriverManager.getConnection(URL, UESNAME, PASSWORD);

			// 3. SQL 작성(작업 지시서)
			String sql = "insert into tbl_diart(diaryword, memId) values(?,?)"; // ? = 스테이트 = 뭐가 올지 모르니깐 일단 비워둔다는 뜻

			// 4. 일꾼 선택(생성)
			pstmt = conn.prepareStatement(sql);

			// 5. 데이터 주입
			pstmt.setString(1, diaryDto.getDiartWord());
			pstmt.setString(2, diaryDto.getmemId());

			// 6. 작업 지시
			result = pstmt.executeUpdate(sql);

			/*
			 * executeQuery() : select, 반환형(ResultSet) -> while문으로 사용하자 executeUpdate() :
			 * insert, update, delete, 반환형(int) -> 영향을 받은 행 수
			 */

			
		} catch (Exception e) {
			e.printStackTrace();

		} finally { // 역순으로 해야 깔끔하게 삭제됨

			// 8. 외부 자원 해제
			try { // 방어 개체
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();

			}
			
			return result;
		}

		
	}
