package com.second.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.second.model.Employee;

@Service
public class EmployeeService {
	static List<Employee> employee = new ArrayList<Employee>();
	static {
		employee.add(new Employee(1, "hulk", 100));
		employee.add(new Employee(2, "ironman", 200));
		employee.add(new Employee(3, "bruce", 200));

	}

	public void addEmployee(String id, String name, String salary) {
		employee.add(new Employee(Integer.parseInt(id), name, Integer.parseInt(salary)));

	}

	
	public String getLogedinUserName()
	{
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
		{
			return ((UserDetails)principal).getUsername();
		}
		return principal.toString();
	}
	
	public void deleteEmployee(int id) {
		Iterator<Employee> iterator = employee.iterator();
		while (iterator.hasNext()) {
			Employee emp = iterator.next();
			if (emp.getId() == id)  {
				iterator.remove();
			}
			/*
			 * for(Employee e:employee){ if(e.getId()==id) { employee.remove(e); } }
			 */
		}
	}
	
	public Employee retrieveEmployee(int id)
	{
		Iterator<Employee> iterator=employee.iterator();
		while(iterator.hasNext())
		{
			Employee e=iterator.next();
			if(e.getId()==(id))
			{
				return e;
			}
		}
		return null;		
	}

	/*public Employee getEmployee(String name) {

		for (Employee e1 : employee) {
			System.out.println("name in for loop is " + e1.getName());
			if (e1.getName() == name) {
				System.out.println("name in if condition is " + e1.getName());
				return e1;
				// break;
			}
		}
		return null;
	}*/

	public List<Employee> getAllEmployees() {
		List<Employee> allList = new ArrayList<Employee>();
		for (Employee e : employee) {
			allList.add(e);
		}
		return allList;
	}
}
