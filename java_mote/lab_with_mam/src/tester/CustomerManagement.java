package tester;

import static utils.CustomerValidationRules.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Customer;

public class CustomerManagement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// exam tip : start with populated sample data and delete before uploading
			Map<String, Customer> customers = new HashMap<>();
			boolean exit = false;
			while (!exit) {
				System.out
						.println("1. Sign up\n" + "2. Sign in\n" + "3. Change password\n" + "4. Unsubscribe customer\n"
								+ "5. Display all customers.\n" + "0. Exit\n" + "Choose an option : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter details : ( firstName,  lastName,  emailId,  password,\r\n"
								+ "			 registrationAmount,  dob(yyyy-MM-dd),  plan )");
						Customer validatedCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.put(validatedCustomer.getEmailId(), validatedCustomer);
						System.out.println(validatedCustomer);
						break;

					case 2:
						System.out.println("enter email");
						authenticateCustomer(sc.next(), sc.next(), customers);

					default:
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace(); // to make debug easy
					sc.nextLine(); // in case if there is any pending scanner to complete it }

				}
			}

		}

	}
}
