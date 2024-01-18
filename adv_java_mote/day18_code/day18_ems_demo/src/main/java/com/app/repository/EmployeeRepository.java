package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	//select e from Employee e where e.dept.id=:id
	List<Employee> findByDeptId(Long deptId);
}
