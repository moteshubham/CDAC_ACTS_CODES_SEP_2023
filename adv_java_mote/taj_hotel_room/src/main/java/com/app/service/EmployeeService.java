package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	String addEmployeeDetails(Employee newEmployee, Integer empId);
	List<Employee> viewAllEmployees();
}
