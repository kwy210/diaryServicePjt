package com.office.diary;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DiaryService {

	final private DiaryDao diaryDao;
	
	public DiaryService(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}

	public int writeNewDiary(HttpServletRequest request, HttpServletResponse response) {
	
		String diaryWord = request.getParameter("diaryword");
		
		HttpSession session = request.getSession();
		String signedMemberId = String.valueOf(session.getAttribute("signedMemberId"));
		
		DiaryDto diaryDto = new DiaryDto(diaryWord, signedMemberId);
		
		int result = diaryDao.insertNewDiary(diaryDto);
		
		
		return result;
	}

	public List<DiaryDto> getMyDiares(HttpServletRequest request, HttpServletResponse response) {
		
		String signInedMemberId = String.valueOf(request.getSession().getAttribute("signinedMemberId"));
		List<DiaryDto> myDiaries = diaryDao.selectDiariesByMemId(signinedMemberId);
		
		return null;
	}
	
}
