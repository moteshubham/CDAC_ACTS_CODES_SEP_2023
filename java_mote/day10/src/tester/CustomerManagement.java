package tester;

import static utils.CustomerValidationRules.authenticateCustomer;
import static utils.CustomerValidationRules.validateAllInputs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;

public class CustomerManagement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Customer> customers = new ArrayList<Customer>();
			boolean exit = false;
			while (!exit) {
				System.out
						.println("1. Sign up\n" + "2. Sign in\n" + "3. Change password\n" + "4. Unsubscribe customer\n"
								+ "5. Display all customers.\n" + "0. Exit\n" + "Choose an option : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter details : ( firstName,  lastName,  emailId,  password,\r\n"
								+ "			 registrationAmount,  dob,  plan");
						Customer validatedCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next().toUpperCase(), customers);
//						shubham mote mote@gmail.com titanic 1000 2000-07-07 SILVER
//						ram chavan ram@gm.com shubh123 2000 1996-01-01 gold
//						rutuja ahire rutu@gmail.com rutu123 1998-05-05 platinum
						System.out.println(validatedCustomer);
						customers.add(validatedCustomer);
						break;

					case 2:
						System.out.println("Enter email and password");
						authenticateCustomer(sc.next(), sc.next(), customers);
						break;
					case 3:

						break;
					case 4:

						break;
					case 5:
						System.out.println(customers);
						for (Customer c : customers)
							System.out.println(c);
						break;
					case 6:

						break;

					default:
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}
		}

	}



}
