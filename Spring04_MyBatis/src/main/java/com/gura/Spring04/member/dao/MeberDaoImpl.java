package com.gura.Spring04.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.Spring04.member.dto.MemberDto;

@Repository  //bean container에 저장되게 한다.
			// @Repository를 붙이지 않으면 @Autowired가 작동하지 않는다.
public class MeberDaoImpl implements MemberDao{
	//의존 객체 주입받기
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
		/*
		 * mapper namespace : member
		 * sql id : insert
		 * parameterType : MemberDto
		 * 
		 * */
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
	}

	@Override
	public MemberDto getData(int num) {
		MemberDto dto = session.selectOne("member.getData", num);
		//-result type은 select된 row 하나를 담을 데이터의 type을 의미한다.
		//selectOne 메소드는 메소드를 실행하고 session.selectOne() 이 resultType을 리턴해준다.
		//담는 형태에 따라 바뀌어짐 - 동적타입
		return dto;
	}

	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list = session.selectList("member.getList");
		// selectList는 리턴 타입이 동적이 아니고 return type이 List이다.
		//										generic 이 result Type
		return list;
	}
	
}
