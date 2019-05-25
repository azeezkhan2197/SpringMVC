package com.second.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Employee {

	
	
	public Employee(){
		super();
	}
	@Min(1)
	int id;
	
	@Size(min=6,message="enter atleast 6 characters")
	String name;
	
	@Min(3)
	int salary;
	
	public Employee(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
