package com.gura.Spring04.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring04.member.dao.MemberDao;
import com.gura.Spring04.member.dto.MemberDto;
/*
 * 비지니스 로직을 처리할 서비스 클래스 정의하기
 * */
//bean이 되도록 어노테이션을 붙인다.
@Service
public class MemberServiceImpl implements MemberService{
	//의존 객체 주입 받기
	@Autowired
	private MemberDao dao;
	
	@Override
	public void addMember(MemberDto dto) {
		//회원 추가
		dao.insert(dto);
	}

	@Override
	public void updateMember(MemberDto dto) {
		//회원 수정
		dao.update(dto);
	}

	@Override
	public void deleteMember(int num) {
		//회원 삭제
		dao.delete(num);
	}

	@Override
	public void getMember(int num, ModelAndView m) {
		//회원 한명의 정보 가져와서
		MemberDto dto = dao.getData(num);
		//m 객체에 담아두기
		m.addObject("dto", dto);
	}

	@Override
	public void getListMember(ModelAndView m) {
		//모든 회원의 정보 가져와서
		List<MemberDto> list = dao.getList();
		//m 객체에 담아두기
		m.addObject("list", list);
	}

}
