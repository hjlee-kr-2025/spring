package com.gyshop.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gyshop.board.service.BoardService;
import com.gyshop.board.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list.do")
	public void list(Model model) {
		
		log.info("list.do");
		model.addAttribute("list", service.list());
	}
	
	@GetMapping("/write.do")
	public void writeForm() {
		log.info("write.do -- Get");
	}
	
	@PostMapping("/write.do")
	public String write(BoardVO vo, RedirectAttributes rttr) {
		
		log.info("write.do -- Post");
		
		log.info(vo);
		
		service.write(vo);
		
		rttr.addFlashAttribute("result", vo.getNo());

		return "redirect:list.do";
	}
}
