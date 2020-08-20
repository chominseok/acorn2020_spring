package test.main5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.WritingUtil;

public class MainClass01 {
	public static void main(String[] args) {
		//코드가 실행되면 init을 이용해서 bean으로 만들것은 만들고 작업한다. > 수행 될 때 까지만 관리됨. >> 메모리 절약
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test/main5/intit.xml");
		
		//관리되는 객체중에서 WritingUtil type 객체의 참조값을 얻어온다.
		WritingUtil util = ctx.getBean(WritingUtil.class);
		
		//객체의 메소드 호출하기
		util.write1();
		util.write2();
		util.write3();
	}
}
