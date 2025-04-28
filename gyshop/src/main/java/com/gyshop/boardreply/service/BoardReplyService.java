package com.gyshop.boardreply.service;

import java.util.List;

import com.gyshop.boardreply.vo.BoardReplyVO;

public interface BoardReplyService {

	public int write(BoardReplyVO vo);
	
	public int update(BoardReplyVO vo);
	
	public int delete(Long gno);
	
	public List<BoardReplyVO> list(Long no);
}
