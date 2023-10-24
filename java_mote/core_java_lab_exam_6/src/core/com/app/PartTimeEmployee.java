package core.com.app;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {

	private double hourlyPay;

	public PartTimeEmployee( String aadhaarNumber, String empName, String phoneNumber, LocalDate dateOfJoining,
			double hourlyPay) {
		super( aadhaarNumber, empName, phoneNumber, dateOfJoining);
		this.hourlyPay = hourlyPay;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	@Override
	public String toString() {
		
		return super.toString() + "PartTimeEmployee [hourlyPay=" + hourlyPay + "]";
	}

}
