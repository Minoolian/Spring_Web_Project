package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
// (200325) 현재 클래스의 모든 메서드들의 기본적인 URL경로:해당 URL은 모두 이곳에서 처리 
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {

		// @RequestMapping 어노테이션은 클래스선언과메서드 선언에 사용가능
		log.info("basic.............");
	}
}
