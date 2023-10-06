import java.util.Scanner;

class Compare
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if(num1>num2)
			System.out.println("Greater number is : " + num1);
		else
			System.out.println("Greater number is : " + num2);
	}
}