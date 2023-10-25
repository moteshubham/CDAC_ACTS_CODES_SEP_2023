package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import custom_exception.CustomerHandlingException;

public class CustomerValidationRules {

	public static void checkForDups(String emailId, Map<String, Customer> customerMap)
			throws CustomerHandlingException {
		// String is object so upcasting
		if (customerMap.containsKey(emailId)) {
			throw new CustomerHandlingException("Email already exists");
		}
		System.out.println("Email available");
	}

	public static ServicePlan parseAndValidatePlan(String plan)
			throws CustomerHandlingException, IllegalArgumentException {
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	private static void validateRegAmount(double registrationAmount, ServicePlan plan)
			throws CustomerHandlingException {

		if (registrationAmount < plan.getCharges()) {
			throw new CustomerHandlingException("Amount is less than mentioned plan");
		} else if (plan.getCharges() < registrationAmount) {
			throw new CustomerHandlingException("Amount is more than mentioned plan");
		}
	}

	private static LocalDate parseAndValidateDate(String dob) throws DateTimeParseException {
		return LocalDate.parse(dob);
	}

	public static Customer authenticateCustomer(String emailId, String password, Map<String, Customer> customerMap)
			throws CustomerHandlingException {

		Customer customer = customerMap.get(emailId);
		if (customer == null) {
			throw new CustomerHandlingException("invalid email");
		}
		if (!customer.getPassword().equals(password)) {
			throw new CustomerHandlingException("password wrong");
		}
		System.out.println("Login successful :" + customer.getEmailId());
		return customer;
	}

//	public static boolean loginCheck(boolean login) throws CustomerHandlingException{
//		if(!login)
//			throw new CustomerHandlingException("Not logged in, Login first");
//		System.out.println("Logged in already");
//		
//	}
	public static void changePassword(Customer authenticatedCustomer, String newPassword) {
		authenticatedCustomer.setPassword(newPassword);
		System.out.println("password changed successfully");
	}

	public static void unsubscribe(String emailInput, Map<String, Customer> customersMap)
			throws CustomerHandlingException {
		if (!customersMap.containsKey(emailInput))
			throw new CustomerHandlingException("Email not present");
		customersMap.remove(emailInput);
		System.out.println("Unsubscribed : " + emailInput);
	}

	public static Customer validateAllInputs(String firstName, String lastName, String emailId, String password,
			double registrationAmount, String dob, String plan, Map<String, Customer> customerMap)
			throws CustomerHandlingException, IllegalArgumentException {
		System.out.println("checking started");
		checkForDups(emailId, customerMap);
		System.out.println("check dups done, starting service plan check");
		ServicePlan validPlan = parseAndValidatePlan(plan);
		System.out.println("serivecplan  done, starting reg amount check");
		validateRegAmount(registrationAmount, ServicePlan.valueOf(plan.toUpperCase()));
		System.out.println("reg amount done, starting date check");
		LocalDate validatedDate = parseAndValidateDate(dob);
		System.out.println("date done, starting return customer");

		Customer validatedCustomer = new Customer(firstName, lastName, emailId, password, registrationAmount,
				validatedDate, validPlan);
		System.out.println("Return customer");
		return validatedCustomer;
	}

}
