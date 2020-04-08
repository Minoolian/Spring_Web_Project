package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	//spring 4.3 이상에서 자동처리
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
	}

	@Override
	public BoardVO get(Long bno) {
		return null;
	}

	@Override
	public boolean modify(BoardVO board) {
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		return null;
	}
	
}
