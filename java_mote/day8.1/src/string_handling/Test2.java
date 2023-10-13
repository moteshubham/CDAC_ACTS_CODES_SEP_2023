package string_handling;

import java.util.Date;

//mutable StringBuilder
public class Test2 {

	public static void main(String[] args) {
		// inits a new SB with specified string , n allocates 16 chars
		StringBuilder sb1 = new StringBuilder("testing");
		System.out.println(sb1);// testing
		System.out.println("len= " + sb1.length() + " capa " + sb1.capacity());// 7 23
		StringBuilder sb2=sb1.append(false);
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb1==sb2);
		//method chaining
		sb2=sb1.append('c').append(123.45).
		append(34.567f).append(new Date());
		System.out.println(sb2);
		System.out.println(sb1);
		char[] chars= {'a','b','c'};
		sb1.insert(0,chars);
		System.out.println(sb1);
		System.out.println(sb1.length()+" "+sb1.capacity());
		sb1.delete(0,sb1.length());
		System.out.println("sb contents "+sb1);
		System.out.println(sb1.length()+" "+sb1.capacity());
		sb1.trimToSize();//tries to reduce  capa=length
		System.out.println(sb1.length()+" "+sb1.capacity());
				

	}

}
