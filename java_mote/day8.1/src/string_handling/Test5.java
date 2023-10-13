package string_handling;

import java.util.Arrays;

public class Test5 {

	public static void main(String[] args) {
		String s="testing strings in java in java.lang pkg";
		System.out.println(s.charAt(0)+" "+s.charAt(s.length()-1));
		System.out.println(s.contains("in"));//t
		System.out.println(s.indexOf('t')+" "+s.lastIndexOf('t'));//0 9
		System.out.println(s.indexOf("in",20));
		System.out.println(s.lastIndexOf("in"));
		System.out.println(s.startsWith("test")+" "+s.endsWith("!!!!"));
		System.out.println(s.matches(".*[pkg]"));
		String[] names= {"Anish","Smita","Shubham",
				"Sarita","Kiran","Amiti"};
		//display names sorted as asc (natural order)
		System.out.println("Names in asc order");
		//Internally JVM invokes stable sorting algo. , internally calling 
		//String's compareTo method
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		

	}

}
