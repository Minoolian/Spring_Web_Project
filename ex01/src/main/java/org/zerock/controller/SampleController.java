package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
// (200325) 현재 클래스의 모든 메서드들의 기본적인 URL경로:해당 URL은 모두 이곳에서 처리 
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	// (200330) chap6.3.4 파라미터의 수집=binding, 파라미터를 변환해서 처리해야 한다면 필요가 있다.

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}

	/* (200326) RequestMapping의 몇가지 속성들 */
	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic get...............");
	}

	@GetMapping("/basicOnlyGet") // GET 방식에만 사용가능
	public void basicGet2() {
		log.info("basic get only get............");
	}

	@RequestMapping("")
	public void basic() {

		// @RequestMapping 어노테이션은 클래스선언과메서드 선언에 사용가능
		log.info("basic.............");
	}

	// (200326) 파라미터의 수집과 반환 -> 'localhost:8080/sample/변수=값&변수=값 '으로 확인
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);

		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: " + age);

		return "ex02";
	}

	// (200330) chap6.3.2: 리스트와 제네릭을 이용하여 ids 라는 이름의 여러개의 파라미터가 전달되어도 리스트에 자동으로 수집
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {

		log.info("ids: " + ids);

		return "ex02List";
	}

	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") ArrayList<String> ids) {

		log.info("ids: " + ids);

		return "ex02Array";
	}

	// (200330) chap6.3.3: [인덱스] 형식으로 전달해서 처리, Tomcat에서 []을 처리하기 위해 '['을 %5B로 ']'을
	// %5D로 변경하도록 한다.
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {

		log.info("list dtos: " + list);

		return "ex02Bean";
	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {

		log.info("todo: " + todo);

		return "ex03";
	}
	
	//(200330) chap6.4.1: 기본자료형의 경우 파라미터로 선언하더라도 기본적으로 화면까지 전달되지 않는다. 따라서 강제로 전달받은 파라미터를 Model에 담아서 전달하도록 함(@ModelAttribute)
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto: "+dto);
		log.info("page: "+page);
		
		return "/sample/ex04";
	}
	
	//(200330) chap6.5.1 반환형 void: 호출하는 URL과 동일한 jsp파일 (servlet-context 파일의 설정과 맞물려 URL경로를 View로 처리)
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05.............");
	}
	
	//(200330) chap6.5.3 반환형 객체타입: JSON 타입으로 객체를 변환해서 전달
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.............");
		
		SampleDTO dto=new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	//(200330) chap6.5.4 반환형 ResponseEntity 타입: HttpHeader 객체를 같이 전달할 수 있고, 이를 통해 원하는 HTTP 헤더 메시지 가공이 가능.
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07...........");
		
		String msg="{\"name\": \"홍길동\"}"; //{"name": "홍길동"}
		
		HttpHeaders header=new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
}
