package com.gyshop.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.gyshop.board.vo.BoardVO;

public interface BoardMapper {

	//@Select("select * from board order by no desc")
	// BoardMapper.xml 로 구현
	public List<BoardVO> list();
	
	public Integer write(BoardVO vo);
	
	public BoardVO view(Long no);
	
	public Integer delete(BoardVO vo);
	
	public Integer update(BoardVO vo);
}
