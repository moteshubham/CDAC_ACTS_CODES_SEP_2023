package core.com.app;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {

	private double monthlySalary;

	public FullTimeEmployee(String aadhaarNumber, String empName, String phoneNumber, LocalDate dateOfJoining,
			double monthlySalary) {
		super( aadhaarNumber, empName, phoneNumber, dateOfJoining);
		this.monthlySalary = monthlySalary;
	}
	
	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	public String toString() {
		
		return super.toString() + "FullTimeEmployee [monthlySalary=" + monthlySalary + "]";
	}



}
