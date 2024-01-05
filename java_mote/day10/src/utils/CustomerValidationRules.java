package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import custom_exceptions.CustomerHandlingException;

public class CustomerValidationRules {

	public static void checkForDups(String emailId, List<Customer> customerList) throws CustomerHandlingException {

		Customer newCustomerEmail = new Customer(emailId);
		if (customerList.contains(newCustomerEmail)) {
			throw new CustomerHandlingException("Email already exists");
		}
		System.out.println("Email availableeeee");
	}

	public static int authenticateCustomer(String email, String password, List<Customer> list)
			throws CustomerHandlingException {
		Customer newCust = new Customer(email);
		System.out.println("in authenticate");
		if (list.contains(newCust)) {
			int index = list.indexOf(newCust);
			//System.out.println("found at index : " + index);
			if (list.get(index).getPassword().equals(password)) {
				System.out.println("Signed in successfully : " + email);
				return index;
			} else
				throw new CustomerHandlingException("Wrong password");
		} else
			throw new CustomerHandlingException("Wrong email");
	}
	
	public static void olderThan6(List<Customer> customers) {
		Iterator<Customer> custItr = customers.iterator();
		
		while(custItr.hasNext()) {
		
			if(custItr.next().getDob().isBefore(LocalDate.now().minusMonths(6))){
				custItr.remove();
			}
		}
		
	}
	public static void setNewPassword(int index, String newPassword, List<Customer> customers) {
		customers.get(index).setPassword(newPassword);
		System.out.println("Password Updated");		
	}
	
	public static void unsubscribe(int index,  List<Customer> customers) {
		customers.remove(index);
	}

	public static ServicePlan parseAndValidatePlan(String plan) throws IllegalArgumentException {

		return ServicePlan.valueOf(plan.toUpperCase());
//		if (ServicePlan.valueOf(planBeforeParsing)) }
//		ServicePlan presentPlan = null;
//		for (ServicePlan plan : ServicePlan.values()) {
//			if (plan.name().equalsIgnoreCase(planBeforeParsing)) {
//				presentPlan = plan;
//				System.out.println("given plan is present");
//			}
//		}
//		throw new CustomerHandlingException("Plan is not present");
	}

	private static void parseAndValidateRegAmount(String plan, double registrationAmount)
			throws CustomerHandlingException {
		ServicePlan currentPlan = ServicePlan.valueOf(plan);
		if (currentPlan.getCharges() < registrationAmount) {
			throw new CustomerHandlingException("Amount is less than mentioned plan");
		} else if (currentPlan.getCharges() > registrationAmount) {
			throw new CustomerHandlingException("Amount is more than mentioned plan");
		}
	}

	private static LocalDate parseAndValidateDate(String dob) throws DateTimeParseException {
		return LocalDate.parse(dob);

	}

	public static Customer validateAllInputs(String firstName, String lastName, String emailId, String password,
			double registrationAmount, String dob, String plan, List<Customer> customerList)
			throws CustomerHandlingException, IllegalArgumentException {
		System.out.println("checking started");
		checkForDups(emailId, customerList);
		// System.out.println("check dups done, starting service plan check");
		ServicePlan currentPlan = parseAndValidatePlan(plan);
		// System.out.println("serivecplan done, starting reg amount check");
		parseAndValidateRegAmount(plan, registrationAmount);
		// System.out.println("reg amount done, starting date check");
		LocalDate validatedDate = parseAndValidateDate(dob);
		// System.out.println("date done, starting return customer");
		Customer validatedCustomer = new Customer(firstName, lastName, emailId, password, registrationAmount,
				validatedDate, currentPlan);
		return validatedCustomer;
	}

}
