package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public String addEmployeeDetails(Employee newEmployee, Integer empId) {

		try {
			mgr.persist(newEmployee);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "added succesfully";
	}

	@Override
	public List<Employee> viewAllEmployees() {
		String jpql = "select e from Employee e";
		return mgr.createQuery(jpql, Employee.class).getResultList();
	}

}
