package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	private Date dueDate;

	//(200330) chap6.3.5 @DateTimeFormat:@InitBinder로 날짜변환을 할 수 있지만, 파라미터로 사용되는 인스턴수 변수에 @DateTimeFormat을 적용해도 변환이 가능
	/*
	 * @DateTimeFormat(pattern="yyy/MM/dd")
	 * private Date dueDate;
	 */
}
