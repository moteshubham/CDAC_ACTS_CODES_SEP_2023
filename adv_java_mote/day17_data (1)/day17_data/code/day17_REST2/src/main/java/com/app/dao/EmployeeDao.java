package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Long> {
//currently has access to ONLY : inherited APIs eg : saveAll, save , findById...
	//finder methods
	List<Employee> findByDepartment(String dept);
	//finder method
	Optional<Employee> findByEmailAndPassword(String em,String pass);
}
