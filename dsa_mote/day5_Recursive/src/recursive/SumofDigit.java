package recursive;
//1. Read a number from user the find the sum of digits of the number using recursive function.
import java.util.Scanner;

public class SumofDigit {
	public static int SumofDigit(int num) {
		if (num == 0)
			return 0;
		return (num % 10 + SumofDigit(num / 10));
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int num = sc.nextInt();
		
		int res = SumofDigit(num);
		System.out.println("The sum of digits is: " + res);
	}
}
