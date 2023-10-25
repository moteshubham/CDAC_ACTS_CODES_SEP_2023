package tester;

import static utils.CustomerValidationRules.authenticateCustomer;
import static utils.CustomerValidationRules.olderThan6;
import static utils.CustomerValidationRules.setNewPassword;
import static utils.CustomerValidationRules.validateAllInputs;
import static utils.CustomerValidationRules.unsubscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;

import custom_ordering.CustomerDOBComparator;

import static utils.PopulateCustomer.populatedList;

public class CustomerManagement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Customer> customers = populatedList();
			boolean exit = false;
			while (!exit) {
				System.out.println("\n1. Sign up\n" + "2. Sign in\n" + "3. Change password\n"
						+ "4. Unsubscribe customer\n" + "5. Display all customers.\n" + "6. Sort by email.\n"
						+ "7. Sort by dob n ast name custom.\n8. Remove all  is pending for last 6 months" + "0. Exit\n" + "Choose an option : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter details : (firstName,  lastName,  emailId,  password,\r\n"
								+ "			 registrationAmount,  dob,  plan)");
						Customer validatedCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next().toUpperCase(), customers);
//						shubham mote mote@gmail.com titanic 1000 2000-07-07 SILVER
//						ram chavan ram@gm.com shubh123 2000 1996-01-01 gold
//						rutuja ahire rutu@gmail.com rutu123 10000 1998-05-05 platinum
						System.out.println(validatedCustomer);
						customers.add(validatedCustomer);
						break;

					case 2:
						System.out.println("Enter email and password");
						authenticateCustomer(sc.next(), sc.next(), customers);
						break;

					case 3:
						System.out.println("Enter email and old password");
						int customerIndex = authenticateCustomer(sc.next(), sc.next(), customers);
						System.out.println("Enter new pasword");
						setNewPassword(customerIndex, sc.next(), customers);
						break;

					case 4:
						System.out.println("Enter email and password to Unsubscribe");
						customerIndex = authenticateCustomer(sc.next(), sc.next(), customers);
						unsubscribe(customerIndex, customers);
						break;

					case 5:
						System.out.println("Elements are : ");
						if (customers != null) {
							for (Customer c : customers)
								System.out.println(c);
						}
						break;

					case 6:
						System.out.println("Sort customer details as per email (use natural ordering)");
						Collections.sort(customers);
						for (Customer c : customers) {
							System.out.println(c);
						}
						break;

					case 7:
						System.out.println("Sort customer details as per dob n last name (use custom ordering)");
						Collections.sort(customers, new CustomerDOBComparator());
						for (Customer c : customers) {
							System.out.println(c);
						}
						break;

					case 8:
						System.out.println(
								"Remove all those customer details whose subscription is pending for last 6 months?");
						olderThan6(customers);
						for (Customer c : customers) {
							System.out.println(c);
						}
						break;

					case 0:
						exit = true;
						System.out.println("byee");
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}
		}

	}

}
