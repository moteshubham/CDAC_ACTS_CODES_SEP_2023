package non_generic;

public class Test {

	public static void main(String[] args) {
		// Create a Holder class instance to hold int value : 12345
		Holder intHolder=new Holder(12345);//int --> Integer --> Up casting
		System.out.println(intHolder.getClass()); //class non_generic.Holder
		System.out.println(intHolder.getRef().getClass());//class java.lang.Integer
		int data=(int) intHolder.getRef();//explicit down casting required!!
		// Create a Holder class instance to hold string "12345"
		Holder stringHolder=new Holder("12345");//up casting
		String s=(String)stringHolder.getRef();
		intHolder=stringHolder;
		//data=(int) intHolder.getRef();
		//run time err : ClassCastExc : String can't be cast to Integer
		
	}

}
