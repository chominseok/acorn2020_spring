package com.gura.spring05.shop.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.shop.dao.OrderDao;
import com.gura.spring05.shop.dao.ShopDao;
import com.gura.spring05.shop.dto.OrderDto;
import com.gura.spring05.shop.dto.ShopDto;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void getList(ModelAndView m) {
		shopDao.getList();
	}
	
	/*
	 * [Spring transaction 설정 방법]
	 * 1.pom.xml에 spring-tx dependency 추가
	 * 2.servlet-context.xml에 transaction 설정추가
	 * 3.트랜잭션을 관리 할 서비스의 메소드에 @transactional 어노테이션 붙이기
	 * 
	 * -프로그래머의 코딩으로 트랜잭션에 영향을 주는 Exception을 발생 시키는 방법
	 * 1.DataAccessException 클래스를 상속받은 클래스를 정의하고
	 * 	ex)class MyException extends DataAccessExecption{}
	 * 		throw new MyException("예외 메세지");
	 * 	예외를 발생시킬 조건이라면 위와 같이 예외를 발생시켜서 트랜잭션이 관리 되도록 한다.
	 * */
	
	//db구문을 묶어서 관리, 하나라도 실패하면 다 rollback이 일어난다. 다 성공하면 commit
	//@repository의 DataAccessExecption만이 트랜잭션에 영향을 받음
	@Transactional  
	@Override
	public void buy(HttpServletRequest request, ModelAndView m) {
		//1.구입할 상품의 번호를 읽어온다.
		int num = (int)request.getSession().getAttribute("num");
		String id = (String)request.getSession().getAttribute("id");
		//2.상품의 가격을 얻어온다.
		int price = shopDao.getPrice(num);
		ShopDto shopDto = new ShopDto();
		shopDto.setId(id);
		//고객의 정보를 들고와야 되는거 아닌가????  아니면 가격을 들고온다는 전제하에
		//다른 테이블의 dto는 안만드나?
		
		//3.상품의 가격만큼 계좌 잔액을 줄인다.
		shopDao.minusMoney(shopDto);
		//4.가격의 10%를 포인트로 적립한다.
	    shopDao.plusPoint(shopDto);
		//5.재고의 갯수를 1 줄인다.
		shopDao.minusCount(num);
		//6.주문 테이블(배송)에 정보를 추가한다.
		OrderDto orderDto = new OrderDto();
		//orderDto.setNum(시퀀스로 가져오기);
		orderDto.setId(id);
		orderDto.setCode(num);
		//orderDto.setAddr(받아온 주소 넣기);
		//orderDao.addOrder(dto);
	}
}
