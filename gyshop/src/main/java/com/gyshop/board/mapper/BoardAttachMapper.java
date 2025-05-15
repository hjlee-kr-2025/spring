package com.gyshop.board.mapper;

import java.util.List;

import com.gyshop.board.vo.BoardAttachVO;

public interface BoardAttachMapper {

	public void insert(BoardAttachVO vo);
	
	public void delete(String uuid);
	
	public List<BoardAttachVO> list(Long no);
}
