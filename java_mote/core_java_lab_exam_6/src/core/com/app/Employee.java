package core.com.app;

import java.time.LocalDate;

import enums.Status;

/*6. Write a console-based Java application for a company to manage employee details.

There are two types of employees – Full Time Employee (FTE), Part Time Employee (PTE)

Application captures following details for each employee whether FTE or PTE:
       Name, Date of joining, Phone Number, Aadhaar number  
For FTE, monthly salary is also captured.
For PTE, hourly payment amount is also captured.

Same collection class is used to store both FTE and PTE

Input should be validated before entering into the system:
Emp Id should be auto generated and unique for each employee.
Date of joining should be of type LocalDate 
Phone number should be all numeric and of length 10
 Hint : Can use a reg ex : ^[0-9]*$ n use String class's matches method
Aadhaar number should be all numeric and of length 12 only, there should not be any space in between.
 Hint : Can use a reg ex : ^\\S+$ n use String class's matches method
Two employees cannot have same aadhaar number

Application Menu:
Add full time employee
Add part time employee
Delete an employee by Emp Id
Search employee details by Aadhaar number
Display all employee details
Display all employee details sorted by date of joining
Exit*/

public class Employee implements Comparable<Employee> {
	private static int empIDCounter;
	private int empID;
	private String aadhaarNumber;
	private String empName;
	private String phoneNumber;
	private LocalDate dateOfJoining;

	static {
		empIDCounter = 0;
	}

	public Employee( String aadhaarNumber, String empName, String phoneNumber, LocalDate dateOfJoining) {
		super();
		this.empID = ++empIDCounter;
		this.aadhaarNumber = aadhaarNumber;
		this.empName = empName;
		this.phoneNumber = phoneNumber;
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public int compareTo(Employee toCompare) {
		if (this.dateOfJoining.isAfter(toCompare.dateOfJoining))
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", aadhaarNumber=" + aadhaarNumber + ", empName=" + empName
				+ ", phoneNumber=" + phoneNumber + ", dateOfJoining=" + dateOfJoining + "]";
	}

	public Employee(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			return this.aadhaarNumber.equals( ((Employee) o).aadhaarNumber);
		}
		return false;
	}

	public int getEmpId() {
		return empID;
	}

	public String getName() {
		return empName;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

}
