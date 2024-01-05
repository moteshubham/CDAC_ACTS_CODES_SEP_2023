package com.app.core;

public class Employee {
	private String empId;
	private String name;
	private int salary;
	public Employee(String empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	//override equals : based upon UID : emp id
	@Override
	public boolean equals(Object o)
	{
		System.out.println("in equals");
		if(o instanceof Employee)
		{
			Employee e=(Employee)o;
			return this.empId.equals(e.empId);			
		}
		return false;
	}
	//override hashCode : to satisfy the contract
	@Override
	public int hashCode()
	{
		System.out.println("in hashCode");
	//	return 100;
		return empId.hashCode();
	}
	
}
