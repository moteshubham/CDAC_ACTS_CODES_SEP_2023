package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
//dep : service layer i/f
	@Autowired
	private EmployeeService empService;

	// Add REST API endpoint , to ret list of all emps
	// http://localhost:8080/employees ,method=GET
	@GetMapping
	public List<Employee> fetchAllEmps() {
		System.out.println("in fetch all");
		return empService.getAllEmps();
	}

	/*
	 * RestConroller rets --> @ResponseBody List<Emp> --> D.S /SC
	 * 
	 * @ResponseBody => marshalling/ser (java --> json) SC uses Jackson for
	 * marshalling --> JSON rep(json [] ) will be sent REST clnt
	 */
	// add API end point for getting emps by dept
	// http://localhost:8080/employees/dept/{deptName} ,method=GET
	@GetMapping("/dept/{deptName}")
	public List<Employee> getEmpsByDept(@PathVariable String deptName) {
		System.out.println("in get emps by dept " + deptName);
		return empService.getEmpsByDepartmentName(deptName);
	}

	// add API end point for adding emp details
	// http://localhost:8080/employees,method=POST
	@PostMapping
	public Employee addEmpDetails(@RequestBody Employee emp) {
		System.out.println("in add emp " + emp);// id : null , rest all fields : present
		return empService.addNewEmp(emp);
	}

	// add API end point for getting emp details by id
	// http://localhost:8080/employees/{empId},method=GET
	@GetMapping("/{empId}")
	public Employee getEmpDetailsById(@PathVariable Long empId) {
		System.out.println("in get emp by id" + empId);
		return empService.getEmpById(empId);
	}

	// add API end point for updating existing emp details
	// http://localhost:8080/employees,method=PUT
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee emp) {
		System.out.println("in update " + emp);
		return empService.updateEmpDetails(emp);
	}
	// add API end point for deleting  existing emp details by it's id
	// http://localhost:8080/employees/{empId},method=DELETE
	@DeleteMapping("/{empId}")//URI variable /template var.
	public String deleteEmpFDetails(@PathVariable Long empId) {
		System.out.println("in del emp "+empId);
		return empService.deleteEmpDetails(empId);
	}

}
