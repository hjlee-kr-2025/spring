package com.gyshop.boardreply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyshop.boardreply.mapper.BoardReplyMapper;
import com.gyshop.boardreply.vo.BoardReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BoardReplyServiceImpl implements BoardReplyService {

	@Setter(onMethod_ = @Autowired)
	private BoardReplyMapper mapper;
	@Override
	public int write(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.write(vo);
	}

	@Override
	public int update(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(Long gno) {
		// TODO Auto-generated method stub
		return mapper.delete(gno);
	}

	@Override
	public List<BoardReplyVO> list(Long no) {
		// TODO Auto-generated method stub
		return mapper.list(no);
	}

}
