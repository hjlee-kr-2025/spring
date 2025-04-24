package com.gyshop.main.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") //@InitBinder 와 같이 사용할 수 없다.
	private Date dueDate;
}
