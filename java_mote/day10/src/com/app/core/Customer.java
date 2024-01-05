package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Customer implements Comparable<Customer> {
	private int customerId;
	private String firstName;
	private String lastName;
	private String emailId; // PK
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idGenerator;
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

	public int compareTo(Customer obj) {
			return this.emailId.compareTo(obj.emailId);
	}

//pk 
	public Customer(String emailId) {
		super();
		this.emailId = emailId;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("in equalsss");
		if (obj instanceof Customer) {
			return this.emailId.equals(((Customer) obj).emailId);
		}
		if (obj instanceof String) {
			return this.password.equals(((Customer) obj).password);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan + "]";
	}

	///// getters and setters

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPassword() {
		return password;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

}
