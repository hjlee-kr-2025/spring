package com.gyshop.board.service;

import java.util.List;

import com.gyshop.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> list();
	
	public BoardVO view(Long no, Integer inc);
	
	public Integer write(BoardVO vo);
	public Integer update(BoardVO vo);
	public Integer delete(BoardVO vo);
}
