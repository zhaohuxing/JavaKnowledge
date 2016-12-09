package com.sprint.io;

import java.io.PrintWriter;
import com.sprint.domain.Employee;
import java.util.Scanner;
import java.util.*;
public class EmployeeIO {
	
	public static void writeData(Employee[] staff, PrintWriter out) {
		for (Employee employee : staff) {
			writeEmployee(employee, out);
		}			
	}

	public static void writeEmployee(Employee employee, PrintWriter out) {
		String data = employee.getName() + "|" + employee.getSalary() + "|" + employee.getHireDay();
		out.println(data);
	}

	public static Employee[] readData(Scanner in) {
		int length = 3;
		Employee[] staff = new Employee[length];
		for (int i = 0; i < length; i++) {
			staff[i] = readEmployee(in);	
		}
		return staff;
	}

	public static Employee readEmployee(Scanner in) {
		String data = in.nextLine();
		String[] message = data.split("\\|");
		Employee employee = new Employee();
		employee.setName(message[0]);
		employee.setSalary(Double.parseDouble(message[1]));
		//GregorianCalendar calendar = new GregorianCalendar();
		Date date = new Date(message[2]);
		employee.setHireDay(date);
		return employee;
	}
}
