package com.office.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberServiceForDW implements IMemberService {

	final private IMemberDao MemberDao;
	
	
	
	public MemberServiceForDW(IMemberDao MemberDao) {
		this.MemberDao = MemberDao;
		
	}

	@Override
	public int signup(HttpServletRequest request, HttpServletResponse response) {
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone = request.getParameter("memPhone");
		
		MemberDto memberDto = new MemberDto(memId, memPw, memMail, memPhone);
		
		boolean isMember = MemberDao.isMember(memId);
		System.out.println("isMember CALLDE:" + isMember);
		
		int result = 0;
		if (!isMember) {
			result = MemberDao.insertNewMember(memberDto);
			
		}
		
		return result;
	}

	@Override
	public MemberDto signin(HttpServletRequest request, HttpServletResponse response) {
	
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		
		MemberDto seletedMemberDto = MemberDao.selectMemberByMemId(memId);
		
		if (seletedMemberDto != null) {
			System.out.println("[MemberService] seletedMemberDto is net null");
			
			if (seletedMemberDto.getMemPw().equals(memPw)) {
				System.out.println("[MemberService] signin  success");

				return seletedMemberDto;
				
			}else {
				System.out.println("[MemberService] signin  fail");
				
				return null;
			}
			
			
			
		} else {
			System.out.println("[MemberService] seletedMemberDto is null");
			System.out.println("[MemberService] signin  fail");
			
			return null;
		}
				
		
	}
	
	
	
}
