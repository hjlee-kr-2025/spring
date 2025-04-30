package com.gyshop.boardreply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyshop.boardreply.service.BoardReplyService;
import com.gyshop.boardreply.vo.BoardReplyVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/boardreply/")
@RestController
@Log4j2
@AllArgsConstructor
public class BoardReplyController {

	private BoardReplyService service;
	
	@PostMapping(value = "/write", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> write(@RequestBody BoardReplyVO vo) {
		log.info("BoardReplyVO : " + vo);
		int insertCount = service.write(vo);
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/list/{no}", produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<BoardReplyVO>> list(@PathVariable("no") Long no) {
		log.info("BoardReplyController list()----- no: " + no);
		return new ResponseEntity<>(service.list(no), HttpStatus.OK);
	}
}
