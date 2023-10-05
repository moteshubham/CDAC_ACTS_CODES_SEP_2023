import java.util.Scanner;
import java.lang.*;

clas FoodMenu
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("-------Food Menu--------");
			System.out.println("1. Samosa");
			System.out.println("2. Dosa");
			System.out.println("3. Idli");
			System.out.println("4. Upma");
			System.out.println("5. Shira");
			System.out.println("6. Pohe");
			System.out.println("7. Utappa");
			System.out.println("8. Tea");
			System.out.println("9. Coffee");
			System.out.println("10. Generate Bill");
			System.out.print("Enter the choice : ");
			int choice = sc.nextInt();
			System.out.print("Enter quantity : ");
			int qty = sc.nextInt();

		}
	}
}