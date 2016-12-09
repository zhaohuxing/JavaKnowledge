package com.sprint.domain;

import java.util.*;
public class Employee {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee() {}
	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		hireDay = calendar.getTime();
	}

	public String getName() {
		return this.name;
	}

	public double getSalary() {
		return this.salary;
	}

	public Date getHireDay() {
		return this.hireDay;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	@Override
	public String toString() {
		return "name:" + name + " salary:" + salary + " hireDay:" + hireDay;
	}
}
