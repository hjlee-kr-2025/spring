package com.gyshop.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("Select now()")
	public String getTime();
	
	public String getTime2();
}
