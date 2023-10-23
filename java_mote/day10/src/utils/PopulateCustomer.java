package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;

public class PopulateCustomer {
	public static List<Customer> populatedList(){
		List<Customer> newList = new ArrayList<Customer>();
//		Customer c = new Cust
		newList.add(new Customer ("ram", "chavan", "ram@gmail.com", "ram123", 2000, LocalDate.parse("1996-01-01"), ServicePlan.GOLD));
		newList.add(new Customer ("shubham", "mote", "moteshubham@gmail.com", "shubh123", 1000, LocalDate.parse("2000-01-01"), ServicePlan.SILVER));
		newList.add(new Customer ("prithvi", "sukale", "pvsukale@gmail.com", "pv123", 10000, LocalDate.parse("1992-01-01"), ServicePlan.PLATINUM));
		newList.add(new Customer ("shivam", "bhirud", "bhirud@gmail.com", "shivam123", 5000, LocalDate.parse("1994-01-01"), ServicePlan.DIAMOND));
		return newList;
	}
}
