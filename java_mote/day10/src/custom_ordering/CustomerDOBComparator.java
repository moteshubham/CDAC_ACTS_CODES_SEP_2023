package custom_ordering;

import java.util.Comparator;

import com.app.core.Customer;

public class CustomerDOBComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		if (o1.getDob().isBefore(o2.getDob()))
			return -1;
		if(o2.getDob().isBefore(o1.getDob()))
			return 1;
		return 0;
	}

}
