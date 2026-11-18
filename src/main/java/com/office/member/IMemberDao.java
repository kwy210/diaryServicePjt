package com.office.member;

public interface IMemberDao {

	public boolean isMember(String memId);
	
	public int insertnewMember(MemberDto memberDto);
	
	public MemberDto selectMemberByMemId(String memId);
	
	
	
}
