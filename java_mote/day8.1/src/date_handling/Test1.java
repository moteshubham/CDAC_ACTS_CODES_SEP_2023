package date_handling;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		// create Date class instance to represent curnt date n time
		Date d1 = new Date();
		System.out.println(d1);
		Date d2 = new Date(20000);
		System.out.println(d2);
		System.out.println(d1.before(d2));//f
		System.out.println(d1.after(d2));//t
		System.out.println(d1.equals(d2));//f
		System.out.println("msec " + d1.getTime());// rets no of msecs elapsed after epoch
		System.out.println("msec " + d2.getTime());// rets no of msecs elapsed after epoch
		System.out.println(d1.compareTo(d2));// > 0
	}

}
