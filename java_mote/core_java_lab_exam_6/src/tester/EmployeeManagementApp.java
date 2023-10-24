package tester;

import static utils.EmployeeManagementUtils.deleteEmployeeByEmpID;
import static utils.EmployeeManagementUtils.searchEmployeeByAadhaarNumber;
import static utils.EmployeeValidationRules.aadhaarNumberValidation;
import static utils.EmployeeValidationRules.parseAndValidateDate;
import static utils.EmployeeValidationRules.validateEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import custom_ordering.*;
import core.com.app.Employee;
import core.com.app.FullTimeEmployee;
import core.com.app.PartTimeEmployee;

public class EmployeeManagementApp {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<Employee> empList = new ArrayList<>();

			boolean exit = false;
			while (!exit) {

				System.out.println("\nEmployee Management Menu:");
				System.out.println("1. Add Full-Time Employee");
				System.out.println("2. Add Part-Time Employee");
				System.out.println("3. Delete an Employee by Employee ID");
				System.out.println("4. Search Employee Details by Aadhaar Number");
				System.out.println("5. Display All Employee Details");
				System.out.println("6. Display All Employee Details Sorted by Date of Joining");
				System.out.println("0. Exit");

				System.out.print("Enter your choice: ");
				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine(); // to consume newline character dont forget this
						System.out.print("Enter Employee Name: ");
						String name = sc.nextLine();
						System.out.print("Enter Date of Joining (yyyy-MM-dd): ");
						String dateOfJoining = sc.nextLine();
						System.out.print("Enter Phone Number: ");
						String phoneNumber = sc.nextLine();
						System.out.print("Enter Aadhaar Number: ");
						String aadhaarNumber = sc.nextLine();
						System.out.print("Enter Monthly Salary: ");
						double monthlySalary = sc.nextDouble();
						sc.nextLine();
						validateEmployee(aadhaarNumber, name, phoneNumber, empList);
						LocalDate joiningDateVerified = parseAndValidateDate(dateOfJoining);
						empList.add(new FullTimeEmployee(aadhaarNumber, name, phoneNumber, joiningDateVerified,
								monthlySalary));

						break;

					case 2:
						sc.nextLine(); // to consume newline character dont forget this
						System.out.print("Enter Employee Name: ");
						name = sc.nextLine();
						System.out.print("Enter Date of Joining (yyyy-MM-dd):s ");
						dateOfJoining = sc.nextLine();
						System.out.print("Enter Phone Number: ");
						phoneNumber = sc.nextLine();
						System.out.print("Enter Aadhaar Number: ");
						aadhaarNumber = sc.nextLine();
						System.out.print("Enter Hourly Pay: ");
						double hourlyPay = sc.nextDouble();
						sc.nextLine();
						validateEmployee(aadhaarNumber, name, phoneNumber, empList);
						joiningDateVerified = parseAndValidateDate(dateOfJoining);
						empList.add(
								new PartTimeEmployee(aadhaarNumber, name, phoneNumber, joiningDateVerified, hourlyPay));
						break;

					case 3:
						System.out.println("Enter Employee id to delete : ");
						int empID = sc.nextInt();
						sc.nextLine(); // consumes
						deleteEmployeeByEmpID(empID, empList);
						break;

					case 4:
						 sc.nextLine();
						System.out.println("Enter Employee Aadhaar ID to search : ");
						String checkAadhaarNumber = sc.nextLine();

						aadhaarNumberValidation(checkAadhaarNumber);
						searchEmployeeByAadhaarNumber(checkAadhaarNumber, empList);
						break;

					case 5:
						for (Employee e : empList) {
							System.out.println(e);
						}
						break;

					case 6:
						System.out.println("Employees sorted by date : ");
						Collections.sort(empList, new EmployeeComparator());
						for (Employee e : empList) {
							System.out.println(e);
						}
						break;

					case 0:
						exit = true;
						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Pls retry....");
					// to read off all pending i/ps
					sc.nextLine();
				}
			}

		} // sc.close()
		System.out.println("main over....");
	}



}
