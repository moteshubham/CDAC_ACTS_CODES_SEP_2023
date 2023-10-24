package utils;

import java.util.Iterator;
import java.util.List;

import core.com.app.Employee;
import custom_exceptions.ValidationException;

public class EmployeeManagementUtils {
	public  static void searchEmployeeByAadhaarNumber(String checkAadhaarNumber,List<Employee> empList) throws ValidationException{
		 
		boolean found = false;
		for(Employee e : empList) {
			if(e.getAadhaarNumber().equals(checkAadhaarNumber)) {
				found = true;
				System.out.println(e);
			}
		}
		if(!found) {
			throw new ValidationException("Aadhar not found");
		}
		
	}
	public static void deleteEmployeeByEmpID(int empID, List<Employee> employeeList) throws ValidationException {
		boolean found = false;
		for (Employee e : employeeList) {
			System.out.println("empID : " + empID + " e.getid : " + e.getEmpId());
			if (e.getEmpId() == empID) {
				found = true;
			}
		}
		if (!found) {
			throw new ValidationException("Employee not found");
		}
		Iterator<Employee> empIterator = employeeList.listIterator(empID - 1);
		empIterator.next();
		empIterator.remove();
	}

}
