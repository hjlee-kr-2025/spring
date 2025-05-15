package com.gyshop.main.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gyshop.movie.vo.MovieVO;
import com.gyshop.util.movie.MovieInfoXML;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
	/*	List<MovieVO> list = new ArrayList<>();
		
		MovieInfoXML.getMovieInfoXML(list);
		
		log.info(list);*/
		
		
		return "home";
	}
}
