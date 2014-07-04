package com.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ProjectExceptionHandler {

	private static final Logger logger = Logger.getLogger(ProjectExceptionHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleException(HttpServletRequest req,Exception e) throws Exception {	
		logger.error(" --- Error --- " +  e.getMessage());
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.getMessage());
		mv.addObject("url", req.getRequestURL());
		mv.setViewName("error");
		return mv;
	}
	
}
