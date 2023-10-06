import java.util.Scanner;

class Division
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers");
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		System.out.println("Division of "+ num1 + " " + num2 + "is : " + (num1/num2));
	}
}