package com.gura.Spring04.member.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring04.member.dto.MemberDto;

public interface MemberService {
	public void addMember(MemberDto dto);
	public void updateMember(MemberDto dto);
	public void deleteMember(int num);
	public void getMember(int num, ModelAndView m);
	public void getListMember(ModelAndView m);
}
