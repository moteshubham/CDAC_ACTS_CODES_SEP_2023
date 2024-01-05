package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.com.app.Employee;
import custom_exceptions.AadhaarNumberInvalidException;
import custom_exceptions.PhoneNumberInvalidException;
import custom_exceptions.ValidationException;
import enums.Status;

public class EmployeeValidationRules {

	public static void checkDup(String aadhaarNumber, List<Employee> empList) throws ValidationException {
		Employee checkEmp = new Employee(aadhaarNumber);
		if (empList.contains(checkEmp)) {
			throw new ValidationException("Employee aadhaar is present. DUPLICATE!! ");
		}
	}

	public static void phoneNumberValidation(String phoneNumber) throws PhoneNumberInvalidException {
		String regex = "\\d{10}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phoneNumber);

		if (!m.matches()) {
			throw new PhoneNumberInvalidException("Please enter 10 digits");
		}
	}

	public static void aadhaarNumberValidation(String aadhaarNumber) throws AadhaarNumberInvalidException {

		String regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(aadhaarNumber);
		if (!m.matches()) {
			throw new AadhaarNumberInvalidException("Enter valid aadhar number");
		}
		else
			System.out.println("Aadhaar Valid");
	}

	public static LocalDate parseAndValidateDate(String dated) throws DateTimeParseException {
		return LocalDate.parse(dated);
	}


	public static void validateEmployee(String aadhaarNumber, String empName, String phoneNumber,
			List<Employee> empList) throws ValidationException, DateTimeParseException, PhoneNumberInvalidException,
			AadhaarNumberInvalidException {
		checkDup(aadhaarNumber, empList);
		phoneNumberValidation(phoneNumber);
		aadhaarNumberValidation(aadhaarNumber);
	}
}
