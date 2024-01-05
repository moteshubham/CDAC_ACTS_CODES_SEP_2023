package sets;

import java.util.HashSet;

public class TestDoubleSet {

	public static void main(String[] args) {
		Double d1=Double.valueOf(100);//can try the deprecated API new Double(100)
		Double d2=Double.valueOf(100);
		Double d3=Double.valueOf(100);
		HashSet<Double> hs=new HashSet<>();
		System.out.println(hs.add(d1));//t
		System.out.println(hs.add(d2));//f
		System.out.println(hs.add(d3));//f
		System.out.println(hs.size());//1
		System.out.println(hs);//[100.0]

	}

}
