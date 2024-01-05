package com.app.core;

import java.time.LocalDate;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String emailId; // PK
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idGenerator;
	private Customer reference;
	static {
		idGenerator = 1000;
	}

	public Customer(String firstName, String lastName, String emailId, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan) {
		super();
		this.customerId = ++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ emailId + ", regAmount=" + registrationAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}
//	public String toString() {
//        return "MyObject [reference=" + (this != null ? "Circular Reference" : "null") + "]";
//    }

//	public String toString() {
//		return "MyObject [reference=" + (this != null ? "Circular Reference" : "null") + "]"+"Customer [customerId=" +  ", firstName=" + firstName + ", lastName=" + lastName
//				+ ", emailId=" +  ", password=" + password + ", registrationAmount=" + registrationAmount
//				+ ", dob=" + dob + ", plan=" + plan + "]";
//	}
//	public String toString() {
//		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
//	+ ", regAmount=" + registrationAmount + ", dob=" + dob + ", plan=" + plan + "]";
//	}
	/*
	 * public String toString() { return toString(new HashSet<>()); }
	 * 
	 * private String toString(Set<Customer> visitedCustomers) { if
	 * (visitedCustomers.contains(this)) { return "Circular Reference"; // To avoid
	 * infinite recursion } visitedCustomers.add(this);
	 * 
	 * return "Customer [customerId=" + customerId + ", firstName=" + firstName +
	 * ", lastName=" + lastName + ", email=" + ", regAmount=" + registrationAmount +
	 * ", dob=" + dob + ", plan=" + plan + "]"; }
	 */

	// equals / hashcode : none! Since string: key it has already
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
