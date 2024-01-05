package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//create a web app using spring mvc/spring boot /jsp/servlet with hibernate/jdbc
//requirements -
//the app works with employee deteails to be maintained in a table
//the structure of table is as  follows
//1 employee number
//2 firstname
//3 lastname
//4 city
//5 companyName
//6 create a timestamp (optional)
//7 update a timestamp (optional)

//the app should user... (3 pages)
//1 add emploee details
//2 view all employee details in tabular format
//3 accept company name from user and display all employee details belonging to the company

//create necessary pojo's, dao, services, controllers, jsp/servlet pages etc


@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@Column(length = 20, name = "first_name")
	private String firstName;
	@Column(length = 20, name = "last_name")
	private String lastName;
	@Column(length = 20, name = "city")
	private String city;
	@Column(length = 20, name = "company")
	private String companyName;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String city, String companyName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.companyName = companyName;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", companyName=" + companyName + "]";
	}
	
}
