import java.util.Scanner;


class TestBox {
	public static void main(String[] args) {
		//create scanner cls instance to wrap stdin
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Box dims : w d h");
		int data=100;
		Box b1;//no box class loaded , no ob created , JVM allocates mem. in the stack , to store the ref type of a var. b1 => class type ref., how many bytes : as per JVM
	//	System.out.println(b1);//javac err : un inited local var
	    b1=new Box(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		System.out.println("b1 from main "+b1);
		//display box dims
		System.out.println(b1.getBoxDetails());
		System.out.println(b1.getBoxVolume());
		Box b2=new Box(1,2,3);
		System.out.println("b2 from main "+b2);
		System.out.println(b2.getBoxDetails());
		System.out.println(b2.getBoxVolume());
		Box b3=b1;//copy of ref.
		System.out.println("b3 from main "+b3);
		System.out.println(b3.getBoxDetails());
		System.out.println(b3.getBoxVolume());
		b1=null;
		System.out.println("b1 from main "+b1);//null
	//	System.out.println(b1.getBoxDetails());//run time err : java.lang.NullpointerException
		b3=null;//1st Box object is marked for GC		
	}
}