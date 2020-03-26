package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
// (200325) 현재 클래스의 모든 메서드들의 기본적인 URL경로:해당 URL은 모두 이곳에서 처리 
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	/* (200326) RequestMapping의 몇가지 속성들 */
	@RequestMapping(value = "/basic", method= {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("basic get...............");
	}
	
	@GetMapping("/basicOnlyGet") //GET 방식에만 사용가능
	public void basicGet2() {
		log.info("basic get only get............");
	}
	
	@RequestMapping("")
	public void basic() {

		// @RequestMapping 어노테이션은 클래스선언과메서드 선언에 사용가능
		log.info("basic.............");
	}
	
	
	//(200326) 파라미터의 수집과 반환 -> localhost:8080/sample/~ 로 확인
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: "+name);
		log.info("age: "+age);
		
		return "ex02";
	}
}
