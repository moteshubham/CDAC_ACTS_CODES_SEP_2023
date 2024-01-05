package tester;

import static utils.CustomerValidationRules.authenticateCustomer;
import static utils.CustomerValidationRules.changePassword;
import static utils.CustomerValidationRules.unsubscribe;
import static utils.CustomerValidationRules.validateAllInputs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Customer;

import custom_exception.CustomerHandlingException;

public class CustomerManagement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// exam tip : start with populated sample data and delete before uploading
			Map<String, Customer> customers = new HashMap<>();
			boolean exit = false;

			while (!exit) {
				System.out.println("\n\n1. Sign up\n" + "2. Sign in\n" + "3. Change password\n"
						+ "4. Unsubscribe customer\n" + "5. Display all customers.\n"
						+ "6. Sort by Email(primary key)\n7. Sort by DOB.\n" + "0. Exit\n" + "Choose an option : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();

						// shubham mote mote@gmail.com mote123 2000 1996-07-22 GOLD
						// aditya khedkar aditya@gmail.com aditya123 5000 2000-01-01 DIAMOND
						System.out.println(
								"Enter firstName,  lastName,  email,  password, regAmount,  dob(yr-mon-day),  plan");
						Customer customer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.put(customer.getEmailId(), customer);
						System.out.println("customer signed up !");
						System.out.println(customer);

						break;

					case 2:
						System.out.println("Enter email : ");
						String emailInput = sc.next();
						String passwordInput = sc.next();

						authenticateCustomer(emailInput, passwordInput, customers);

						break;

					case 3:
						System.out.println("Enter email & Old password : ");
						emailInput = sc.next();
						passwordInput = sc.next();
						Customer authenticatedCustomer = authenticateCustomer(emailInput, passwordInput, customers);
						System.out.println("Enter new password : ");
						String newPasswordInput = sc.next();
						changePassword(authenticatedCustomer, newPasswordInput);

						break;
					case 4:
						System.out.println("Enter email to unsubscribe : ");
						emailInput = sc.next();
						unsubscribe(emailInput, customers);
						break;
					case 5:
						System.out.println("All customer details : ");
						if (customers != null) {
							for (Customer c : customers.values())
								System.out.println(c);
						} else
							throw new CustomerHandlingException("Map is Null..");
						break;
					case 6:
						System.out.println("Sorted as per Email : ");
						// List<Customer> listCust = new ArrayList<>(customers.values());
						TreeMap<String, Customer> tree = new TreeMap<>(customers);
						tree.forEach((s, c) -> System.out.println(s + "  " + c));
//						Collections.sort(listCust);
						break;
					case 7:
						System.out.println("Sorted as per DOB : ");
						ArrayList<Customer> arrlist = new ArrayList<>(customers.values());
						Comparator<Customer> comp = (c1, c2) -> c1.getDob().compareTo(c2.getDob());
						Collections.sort(arrlist, comp);
						arrlist.forEach(c -> System.out.println(c));
						break;
					case 0:
						exit = true;
					default:
						break;
					}

				} catch (Exception e) {
					// System.out.println(e.getMessage());
					e.printStackTrace(); // to make debug easy
					sc.nextLine(); // in case if there is any pending scanner to complete it }

				}
			}

		}

	}

}
