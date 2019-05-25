package com.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.second.service.EmployeeService;

@Controller
public class WelcomeController {

	@Autowired 
	EmployeeService e=new EmployeeService();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap map) {
		map.put("name",e.getLogedinUserName());
		return "welcome";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login3(ModelMap map) {
		map.put("name",e.getLogedinUserName());
		return "login";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String login2(ModelMap map) {
		map.put("name",e.getLogedinUserName());
		return "welcome";
	}
	
	@RequestMapping(value = "/logout-success", method = RequestMethod.POST)
	public String logoutSuccess(ModelMap map) {
		map.put("name",e.getLogedinUserName());
		return "login";
	}
	

}
