package string_handling;
//immutability of String
public class Test1 {

	public static void main(String[] args) {
		String s = new String("hello");
		s.concat("hi");
		System.out.println(s);// hello
		s += "12345";// s=s+"12345"
		System.out.println(s);// hello12345
		System.out.println(s.toUpperCase());//HELLO12345
		System.out.println(s);//hello12345
		System.out.println(s.replace('l', 'p'));//heppo12345
		System.out.println(s);//hello12345
		String s1=s.replaceFirst("he", "zzz");
		System.out.println(s);//orig
		System.out.println(s1);//replaced
		System.out.println("string len"+s1.length());
		
		

	}

}
