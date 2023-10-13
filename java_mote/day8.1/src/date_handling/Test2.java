package date_handling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
	private static SimpleDateFormat sdf;
	static {
		System.out.println("in static init block");
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	public static void main(String[] args) {
		/*
		 * Accept 2 dates (join date) of 2 emps Prints yes : if 1st emp is senior to
		 * other , o.w print no
		 * 
		 */
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter join date for 1st emp");
			Date joinDate1 = sdf.parse(sc.next());
			System.out.println("Enter join date for 2nd emp");
			Date joinDate2 = sdf.parse(sc.next());
			System.out.println(joinDate1.before(joinDate2)?"Yes":"No");
			System.out.println(joinDate1);//toString
			System.out.println(sdf.format(joinDate1));//formatted string
			System.out.println("end of try");
		} //sc.close()
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("main over....");

	}

}
