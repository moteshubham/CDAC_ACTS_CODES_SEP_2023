package sets;

import java.util.TreeSet;

import custom_ordering.DoubleDescComparator;




public class TestTreeSetDesc {

	public static void main(String[] args) {
		// create empty HS<Double>
		TreeSet<Double> hs = new TreeSet<>(new DoubleDescComparator());// size=0, initCapa=16
		System.out.println(hs); //[]
		double[] doubles = { 1, 2.4};
		// populate the set
		for (double d : doubles)
			System.out.println("Added " + hs.add(d));// auto boxing double --> Double
		//While populating this TS : Double's compareTo
		System.out.println("TS via toString " + hs);
		System.out.println("size "+hs.size());
	}

}
