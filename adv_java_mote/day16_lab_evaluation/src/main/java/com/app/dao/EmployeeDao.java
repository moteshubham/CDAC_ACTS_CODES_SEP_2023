package com.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public interface EmployeeDao {
	String addEmployeeDetails(Employee newEmployee, Integer empId);
	List<Employee> viewAllEmployees();
}
