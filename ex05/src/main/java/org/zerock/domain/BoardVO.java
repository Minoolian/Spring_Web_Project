package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

// Lobmok을 통해 생성자, getter/setter, toString() 자동생성
@Data
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
	private int replyCnt;
	
	private List<BoardAttachVO> attachList;
}
