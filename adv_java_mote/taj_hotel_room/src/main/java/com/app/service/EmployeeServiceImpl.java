package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String addEmployeeDetails(Employee newEmployee, Integer empId) {
		return employeeDao.addEmployeeDetails(newEmployee, empId);
	}

	@Override
	public List<Employee> viewAllEmployees() {
		
		return employeeDao.viewAllEmployees();
	}
	


}
