package utils;

import java.security.Provider.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.zip.CheckedOutputStream;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import custom_exceptions.CustomerHandlingException;

public class CustomerValidationRules {

	public static void checkForDups(String emailId, List<Customer> customerList) throws CustomerHandlingException {
		Customer newCustomerEmail = new Customer(emailId);
		if (customerList.contains(newCustomerEmail)) {
			throw new CustomerHandlingException("Email already exists");
		}
		System.out.println("Email available");
	}

	public static ServicePlan parseAndValidatePlan(String planBeforeParsing)
			throws CustomerHandlingException, IllegalArgumentException {
//		if (ServicePlan.valueOf(planBeforeParsing)) }
		ServicePlan presentPlan = null;
		for (ServicePlan plan : ServicePlan.values()) {
			if (plan.name().equalsIgnoreCase(planBeforeParsing)) {
				presentPlan = plan;
				System.out.println("given plan is present");
			}
		}
		throw new CustomerHandlingException("Plan is not present");
	}

	private static void parseAndValidateRegAmount(String plan, double registrationAmount) throws CustomerHandlingException {
		ServicePlan currentPlan = ServicePlan.valueOf(plan);
		if (currentPlan.getCharges() < registrationAmount) {
			throw new CustomerHandlingException("Amount is less than mentioned plan");
		} else if (currentPlan.getCharges() > registrationAmount) {
			throw new CustomerHandlingException("Amount is more than mentioned plan");
		}
	}
	
	private static LocalDate parseAndValidateDate(String dob) {
		return LocalDate.parse(dob);
		
	}
	

	public static Customer validateAllInputs(int customerId, String firstName, String lastName, String emailId,
			String password, double registrationAmount, String dob, String plan, List<Customer> customerList) throws CustomerHandlingException, IllegalArgumentException{
		System.out.println("checking started");
		checkForDups(emailId, customerList);
		System.out.println("check dups done, starting service plan check");
	ServicePlan currentPlan = parseAndValidatePlan(plan);
	System.out.println("serivecplan  done, starting reg amount check");
		parseAndValidateRegAmount(plan, registrationAmount);
		System.out.println("reg amount done, starting date check");
		LocalDate validatedDate = parseAndValidateDate(dob);
		System.out.println("date done, starting return customer");
		Customer validatedCustomer = new Customer(customerId, firstName, lastName, emailId, password, registrationAmount, validatedDate, currentPlan);
		return validatedCustomer;
	}



}