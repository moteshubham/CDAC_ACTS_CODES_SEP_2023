package com.app.service;

import java.util.List;

import com.app.dto.DepartmentDTO;
import com.app.dto.DepartmentEmpsDTO;
import com.app.entities.Department;

public interface DepartmentService {
	List<Department> getAllDepartmens();
	DepartmentDTO getDepartmentDetails(Long deptId);
	DepartmentDTO addNewDepartment(DepartmentDTO dept);
	DepartmentEmpsDTO getDepartmentAndEmpDetails(Long deptId);
	
}
