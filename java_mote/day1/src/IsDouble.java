import java.lang.*;
import java.util.Scanner;

//Accept 2 double values from User (using Scanner). Check data type.
//If arguments are not doubles , supply suitable error message & terminate.
//If numbers are double values , print its average.
//Hint : Method of Scanner to use : hasNextDouble , nextDouble 


class IsDouble
{
	public static void main(String [] args)
	{
	 	double num1;
		double num2;
		Scanner sc = new Scanner(System.in);

		if(sc.hasNextDouble() && sc.hasNextDouble())
		{
			num1 = sc.nextDouble();
			num2 = sc.nextDouble();
			System.out.println("Average is : " + ((num1+num2)/2));
		}
		else
		{
			System.out.println("Numbers are not double");
		}
	}
}