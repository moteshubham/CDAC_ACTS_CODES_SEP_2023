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

	@Override
	public String toString() {
		return "Customer \n[customerId : " + customerId + ", \nfirstName : " + firstName + ", \nlastName : " + lastName
				+ ", \nemailId : " + emailId + ", \nregistrationAmount : " + registrationAmount + ", \ndob : " + dob + ", \nplan : "
				+ plan + "]";
	}

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
