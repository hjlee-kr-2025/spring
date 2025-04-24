package com.gyshop.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gyshop.board.mapper.BoardMapper;
import com.gyshop.board.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	// 자동 DI: @Setter+spring (lombok+spring), @Autowired (spring), @Inject(라이브러리)
	//@Inject
	// spring 4.3 이상버전 @AllArgsConstructor 로 자동처리
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public BoardVO view(Long no, Integer inc) {
		// TODO Auto-generated method stub
		return mapper.view(no);
	}

	@Override
	public Integer write(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.write(vo);
	}

	@Override
	public Integer update(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public Integer delete(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.delete(vo);
	}

}
