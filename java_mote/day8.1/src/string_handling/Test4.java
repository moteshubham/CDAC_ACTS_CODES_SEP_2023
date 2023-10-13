package string_handling;
//literal vs non literal string
public class Test4 {

	public static void main(String[] args) {
		String s1="hello";
		String s2="hello";
		String s3=new String(s1);
		String s4="Hello";
		System.out.println(s1.equals(s2));//t
		System.out.println(s1.equals(s3));//t
		System.out.println(s1.equals(s4));//f
		System.out.println(s1.equalsIgnoreCase(s4));//t
		System.out.println(s1==s2);//t
		System.out.println(s1==s3);//f
		System.out.println(s1==s4);//f
		s1=s2=s3=s4=null;//How many objs are marked for GC : 1
		String s5="hello";//s5 --> already existing string in literal pool
			

	}

}
