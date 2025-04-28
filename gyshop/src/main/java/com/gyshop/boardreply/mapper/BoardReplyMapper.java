package com.gyshop.boardreply.mapper;

import java.util.List;

import com.gyshop.boardreply.vo.BoardReplyVO;

public interface BoardReplyMapper {

	public List<BoardReplyVO> list(Long no);
	
	public int write(BoardReplyVO vo);
	
	public int update(BoardReplyVO vo);
	
	public int delete(Long gno);
}
