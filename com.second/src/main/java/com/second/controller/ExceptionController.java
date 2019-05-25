package com.second.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class ExceptionController {
	
	Log logger=LogFactory.getLog(ExceptionController.class);
	
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(HttpServletRequest request,Exception exception)
	{
		logger.error("request: "+request.getRequestURL()+" raised "+exception);
		return "error";
	}

}
