package com.gyshop.boardreply.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardReplyVO {

	private Long rno;
	private String content;
	private Long no;
	private String id;
	private Date writeDate;
}
