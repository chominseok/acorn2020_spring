////package com.gura.Spring04.member.dao;
//
////import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Repository;
//
//import com.gura.Spring04.member.dto.MemberDto;
//
////Component scan을 했을 때 bean이 되도록 어노테이션을 붙인다.
////Dao에는 @Repository라는 어노테이션을 붙인다. >>> class가 bean container에 저장됨
//@Repository
////public class MemberDaoTest {
//	//spring이 관리하고 있는 객체를 주입 받으려면 @Autowired 어노테이션을 붙인다.
//	//spring이 관리하고 있는 객체 중에서 SqlSession type이 존재하면 자동 주입된다.
//	@Autowired //>> 메소드를 호출하면 세션이 작동하고 어노테이션 도움으로 자동적으로 주입된다.
////	private SqlSession session;
//	
//	//회원 한명의 정보를 저장하는 메소드
////	public void insert(MemberDto dto) {
////		session.insert("member.insert", dto);
//		// insert(a.b , c)
//		// a :  mapper namespace="member"> 맵퍼의 식별값
//		// b : 어떤 sql문을 실행할 지 xml의 sql구문의 id와 맞춰준다.
//		// c : 파라미터 type
//	}
//	
//	//회원 한명의 정보를 삭제하는 메소드
////	public void delete (int num) {
////		session.delete("member.delete", num);
//	}
//	
//	//회원 한명의 정보를 리턴하는 메소드
////	public MemberDto getData(int num) {
//		//한개의 결과를 추출하는 selectOne  >> 결과 row가 하나일 때
////		MemberDto dto = session.selectOne("member.getData", num);
//		//그때그때마다 type을 정해줄 수 있따. session.은 리터해주는 값이 정해져있지 않다. >  동적임
////		return dto;
//	}
//}
