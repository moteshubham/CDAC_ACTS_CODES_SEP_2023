package time_parsing;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TimeParsing {

	

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			
			LocalDate date = LocalDate.now();
			LocalDate date2 = LocalDate.of(2023, 10, 15);
			System.out.println("Enter date in  format yyyy-MM-dd");
			LocalDate date3 = LocalDate.parse(sc.next());
			System.out.println(date);
			System.out.println(date2);
			System.out.println(date3);
		} catch (DateTimeParseException e) {
			System.out.println("getmsg");
			e.getMessage();
			System.out.println(e.hashCode());
			
			System.out.println("stack");
			e.printStackTrace();
		}
	}

}
