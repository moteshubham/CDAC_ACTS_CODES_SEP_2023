package com.app.service;

import java.util.List;

import com.app.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmps();

	List<Employee> getEmpsByDepartmentName(String deptName);

	Employee addNewEmp(Employee emp);

	Employee getEmpById(Long empId);

	Employee updateEmpDetails(Employee emp);

	String deleteEmpDetails(Long empId);
}
