package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//현재 코드가 스프링을 실행하는 역할임을 표시
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//지정된 클래스나 문자열을 이용해 필요한 객체들을 스프링 내에 객체로 등록
@Log4j
//lombok을 이용해 로그를 기록하는 logger를 변수로 생성
public class SampleTests {

	@Setter(onMethod_ = {@Autowired})
	//해당 인스턴스 변수가 스프링으로 부터 자동주입, 가능하다면 obj 변수에 Restaurant 객체를 주입
	private Restaurant restaurant;
	
	@Test
	//JUnit에서 테스트 대상을 표시
	public void testExist() {
		assertNotNull(restaurant);
		//restaurant 변수가 null이 아닐 경우 테스트가 성공한다는 의미 (습관을 가지는 것이 중요)
		
		log.info(restaurant);
		log.info("----------------------------------");
		log.info(restaurant.getChef());
	}
}
