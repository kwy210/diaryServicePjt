package com.office.diary;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DiaryService {

	final private DiaryDao diaryDao;
	
	public DiaryService(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}

	public int writeNewDiary(HttpServletRequest request, HttpServletResponse response) {
	
		String diaryWrod = request.getParameter("diaryWord");
		HttpSession session = request.getSession();
		String signedMemberId = String.valueOf(session.getAttribute("signedMemberId"));
		
		DiaryDto diaryDto = new DiaryDto(diaryWrod, signedMemberId);
		
		int result = diaryDao.insertNewDiary(diaryWrod);
		
		
		return result;
	}
	
}
