package custom_ordering;

import java.util.Comparator;

public class DoubleDescComparator implements Comparator<Double> {

	@Override
	public int compare(Double o1, Double o2) {
		System.out.println("in compare");
		return o2.compareTo(o1);
	}

}
