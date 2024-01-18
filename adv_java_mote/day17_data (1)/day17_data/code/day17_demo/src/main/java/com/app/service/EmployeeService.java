package com.app.service;

import java.util.List;

import com.app.dto.AddEmployeeDTO;
import com.app.dto.EmployeeRespDTO;

public interface EmployeeService {
//get list of emps from a specific dept
	List<EmployeeRespDTO> getAllEmployeesFromDept(Long deptId);

//delete emp details
	String deleteEmpDetails(Long empId);

	EmployeeRespDTO addNewEmployee(AddEmployeeDTO dto);

	EmployeeRespDTO updateEmployee(Long empId, AddEmployeeDTO dto);

	EmployeeRespDTO getEmpDetails(Long deptId, Long empId);
	//get all emps : pagination
	List<EmployeeRespDTO> getAllEmployees(int pageNumber,int pageSize);
	
}
