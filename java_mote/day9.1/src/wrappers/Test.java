package wrappers;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// Integer i1=new Integer(100);
		Integer i1 = Integer.valueOf(100); // boxing (prim --> Wrapper)
		Integer i2 = Integer.valueOf("12345");// boxing
		int data = i1.intValue();// un boxing
		Integer i3 = 12345;// auto boxing
		System.out.println(i3.getClass()); // java.lang.Integer
		Double d1 = 34.56;// auto boxing : java.lang.Double
		String s = "2345";
		System.out.println(s.getClass()); //class java.lang.String
		// s++;//u can't use arithmetic opearators with ref types!
		i1++;
		/*
		 * implicit conversions : auto un boxing : int tmp=i1.intValue() tmp++; auto
		 * boxing i1=new Integer(tmp) / Integer.valueOf(tmp)
		 */
		System.out.println(i1);// 101
		i1 *= 20;
		System.out.println(i1);
		double d2 = 123.45f;// widening conversion : impl done by javac
		// Double d3=123.456f;//auto boxing float --> Float ---X--> Double
		Double d3 = (double) 123.456f;// auto boxing
		// Double d4=12345;
		Number n1 = 123.456f;// autoboxing--> up casting
		System.out.println(n1.getClass());// java.lang.Float
		n1 = 100;
		System.out.println(n1.getClass());// java.lang.Integer
		// n1=true;//incompatible types !
		Object o = 100;//auto boxing , upcasting
		o = 123.456F;//auto boxing , upcasting
		o = 12.456;//auto boxing , upcasting
		o = false;//auto boxing , upcasting
		System.out.println(o.getClass());//java.lang.Boolean
		o = new Date();//up casting
		o = "dfgfdgdf";//up casting
		/*
		 * Java is not pure OOP based language.(since it 
		 * supports primitive types , for the efficiency purpose)
		 * BUT Object type of a ref(Object o) can DIRECTLY
		 * refer to any prim type(auto boxing, up casting) as well as
		 * ref type(up casting)
		 * 
		 */

	}

}
