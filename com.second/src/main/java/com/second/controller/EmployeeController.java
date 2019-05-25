package com.second.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.second.model.Employee;
import com.second.service.EmployeeService;

@Controller
@SessionAttributes("name")
public class EmployeeController {
	@Autowired
	EmployeeService eService = new EmployeeService();

	@RequestMapping(value = "/showEmployee", method = RequestMethod.GET)
	public String retrieveList(ModelMap map, String name) {
		List<Employee> e = eService.getAllEmployees();
		map.addAttribute("employee", e);
		return "info";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployeePage(ModelMap map) {
		map.addAttribute("employee",new Employee());
		return "addEmployee";

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(ModelMap map, @Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "addEmployee";			
		} 
		else {
			eService.addEmployee(Integer.toString(employee.getId()), employee.getName(), Integer.toString(employee.getSalary()));
			map.clear();
			return "redirect:/showEmployee";
		}
	}
	
	@SuppressWarnings("unused")
	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam String id) {
		int ID = Integer.parseInt(id);
		eService.deleteEmployee(ID);
		return "redirect:/showEmployee";
	}
	
	@RequestMapping(value="/logout" ,method=RequestMethod.GET)
	private String logout(ModelMap map,HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		/*
		 * if(auth!=null) { new
		 * SecurityContextLogoutHandler.logout(request,response,auth); }
		 */
		session.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/editEmployee",method=RequestMethod.GET)
	public String editEmployee(ModelMap model,@RequestParam int id) throws Exception
	{
		//throw new Exception("dummy Exception");
		
		  Employee e=eService.retrieveEmployee(id); eService.deleteEmployee(id);
		  model.addAttribute("employee",e); return "addEmployee";
		 
	}
}
