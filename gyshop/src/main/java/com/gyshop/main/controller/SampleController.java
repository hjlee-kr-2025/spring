package com.gyshop.main.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyshop.main.domain.SampleDTO;
import com.gyshop.main.domain.SampleDTOList;
import com.gyshop.main.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample/")
@Log4j2
public class SampleController {
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@RequestMapping("")
	public void basic() {
		log.info("basic................");
	}
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get............");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get............");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info("" + dto);
		
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info("name = " + name);
		log.info("age = " + age);
		
		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		// ArrayList에서는 @RequestParam 생략불가
		log.info("ids = " + ids);
		
		return "ex02List";
	}

	@GetMapping("/ex02Array")
	public String ex02Array(String[] ids) {// @RequestParam("ids") 생략
		log.info("array ids = " + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	// "/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B1%5D.name=bbb&list%5B2%5D.name=ccc"
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {// @RequestParam("ids") 생략
		log.info("list dtos : " + list);
		
		return "ex02Bean";
	}
	
	
	// "/sample/ex03?title=test&dueDate=2025-04-24"
	// @InitBinder 처리를 안하면 400 error 발생
	// DTO에 @DateTimeFormat() 사용해도 됩니다. @InitBinder와 동시에 사용불가
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo = " + todo);
		
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto = " + dto);
		log.info("page = " + page);
		
		
		// jsp에서 클래스이름(앞글자만소문자로변경, sampleDTO)으로 사용하면 화면에 표시할 수 있습니다.
		// getter/setter가 기본구성되어있는 클래스(JavaBean규칙에 맞는)
		
		// 기본자료형은 불가.
		// 기본자료형은 @ModelAttribute 어노테이션을 붙여서 사용하면 전달가능
		
		return "sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05...............");
	}

	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06...............");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}

	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07...............");
		
		String msg = "{\"name\": \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	

}
