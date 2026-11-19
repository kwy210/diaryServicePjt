package com.office.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberServiceForDW implements IMemberService {

	final private IMemberDao iMemberDao;
	
	public MemberServiceForDW(IMemberDao iMemberDao) {
		this.iMemberDao = iMemberDao;
		
	}

	@Override
	public int signup(HttpServletRequest request, HttpServletResponse response) {
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone = request.getParameter("memPhone");
		
		MemberDto memberDto = new MemberDto(memId, memPw, memMail, memPhone);
		
		boolean isMember = iMemberDao.isMember(memId);
		System.out.println("isMember CALLDE:" + isMember);
		
		int result = 0;
		if (!isMember) {
			result = iMemberDao.insertNewMember(memberDto);
			
		}
		
		return result;
	}

	@Override
	public int signin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
