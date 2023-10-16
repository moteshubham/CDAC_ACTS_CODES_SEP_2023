package generic;

public class Test {

	public static void main(String[] args) {
		// Create a Holder class instance to hold int value : 12345
		//<> => diamond operator : type of RHS is deduced/inferred from LHS
		Holder<Integer> intHolder=new Holder<>(12345);//auto boxing
		int data=intHolder.getRef();//auto un boxing
		System.out.println(intHolder.getClass());//type erasure ! => generic.Holder
		System.out.println(intHolder.getRef().getClass());//java.lang.Integer
		// Create a Holder class instance to hold string "12345"
		Holder<String> stringHolder=new Holder<>("12345");//impl conversion : NONE !
		String s=stringHolder.getRef();
	//	intHolder=stringHolder;//catching type mismatch errors @ compile time : generics !
		//Javac err : Holder<String> is INCOMPATIBLE with Holder<Integer>
	}

}
