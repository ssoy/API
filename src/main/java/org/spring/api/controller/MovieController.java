package org.spring.api.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;

@Controller
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(value="dailyTop", method = RequestMethod.GET)
	public String movieDailyTop() {
		return "movieDailyTop";
	}
	
	@RequestMapping(value="dailyTop", method = RequestMethod.POST)
	public String movieDailyTop(@ModelAttribute("targetDt") String targetDt, 
			@ModelAttribute("multiMovieYn") String multiMovieYn,
			@ModelAttribute("repNationCd")String repNationCd, Model model) throws OpenAPIFault, Exception {
		logger.info(targetDt);
		logger.info(multiMovieYn);
		logger.info(repNationCd);
		
		List<Map<String, String>> rList = service.movieParse(targetDt, multiMovieYn, repNationCd);
		model.addAttribute("rList", rList);
		
		return "movieDailyTop";
	}
	
}
