package custom_ordering;

import java.util.Comparator;

import core.com.app.Employee;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getDateOfJoining().isAfter(o2.getDateOfJoining())) {
			return 1;
		}
		if(o1.getDateOfJoining().isBefore(o2.getDateOfJoining()))
			return -1;
		return 0;
		
	}
}
