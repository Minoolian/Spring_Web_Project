package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

//(200401) Chap6.6.1: AOP를 이용하는 방식으로 공통적인 예외사항에 대해 @ControllerAdvice를 이용해서 분리하는 방식
@ControllerAdvice // 해당 객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class) //해당메서드가 () 들어가는 예외타입을 처리한다
	public String except(Exception ex, Model model) {
		
		log.error("Exception............"+ex.getMessage());
		model.addAttribute("exception",ex);
		log.error(model);
		return "error_page"; //return 값이 String 이므로 JSP파일의 경로. error_page.jsp
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "custom404"; //custom404.jsp
	}
}
