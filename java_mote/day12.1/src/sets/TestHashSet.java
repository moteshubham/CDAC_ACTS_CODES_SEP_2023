package sets;

import java.util.HashSet;

public class TestHashSet {

	public static void main(String[] args) {
		//create empty HS<Double>
		HashSet<Double> hs=new HashSet<>();//size=0, initCapa=16
		double[] doubles= {1,2.4,4.5,-67.89,1,10,12.4,1.4,1};
		//populate the set
		for(double d : doubles)
			System.out.println("Added "+hs.add(d));//auto boxing double --> Double
		System.out.println("HS via toString "+hs);
		System.out.println("HS contains 10"+hs.contains(10.0));//t
		System.out.println("HS remove "+hs.remove(10.0));//t
		System.out.println("HS via for-each");
		for(double d : hs)
			System.out.print(d+" ");
		//can u attach Iterator ? YES 
		//Can u attach ListIterator : No , no for loop
		

	}

}
