package sets;

import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		// create empty HS<Double>
		TreeSet<Double> hs = new TreeSet<>();// size=0, initCapa=16
		double[] doubles = { 1, 2.4, 4.5, -67.89, 1, 10, 12.4, 1.4, 1 };
		// populate the set
		for (double d : doubles)
			System.out.println("Added " + hs.add(d));// auto boxing double --> Double
		//While populating this TS : Double's compareTo
		System.out.println("TS via toString " + hs);
		System.out.println("size "+hs.size());
	}

}
