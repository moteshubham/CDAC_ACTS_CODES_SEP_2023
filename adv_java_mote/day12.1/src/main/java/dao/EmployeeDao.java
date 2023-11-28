package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Employee;
import pojos.EmploymentType;

public interface EmployeeDao {
//add a method to save emp details
	String saveEmpDetails(Employee transientEmp, Long deptId);

	// add a method to remove an emp from specific dept
	String removeEmpFromDept(String deptName, String email);

	// add a method to get emp details by id
	Employee getEmpDetailsById(Long empId);

	// add a method to load emp details by id
	Employee loadEmpDetailsById(Long empId);

}
