package tester;

import static utils.CustomerValidationRules.validateAllInputs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;
import com.app.core.ServicePlan;
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
						System.out.println("Enter details : ( customerId,  firstName,  lastName,  emailId,  password,\r\n"
								+ "			 registrationAmount,  dob,  plan");
						Customer validatedCustomer =  validateAllInputs(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), customers);
						System.out.println(validatedCustomer);
						break;

					default:
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}

	}




}
