package sets;

import java.util.LinkedHashSet;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		// create empty HS<Double>
		LinkedHashSet<Double> hs = new LinkedHashSet<>();// size=0, initCapa=16
		double[] doubles = { 1, 2.4, 4.5, -67.89, 1, 10, 12.4, 1.4, 1 };
		// populate the set
		for (double d : doubles)
			System.out.println("Added " + hs.add(d));// auto boxing double --> Double
		System.out.println("LHS via toString " + hs);
		System.out.println("size "+hs.size());
	}

}
