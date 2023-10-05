import java.lang.*;
import java.util.Scanner;


class FoodMenu
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		int total = 0;
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
			int qty;
			//if(choice < 10)
			//{
			//	System.out.print("Enter quantity : ");
			//	qty = sc.nextInt();
			//}
			
			switch(choice){
			
				case 1:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 15*qty;
					break;
				case 2:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 50*qty;
					break;
				case 3:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 35*qty;
					break;
				case 4:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 20*qty;
					break;
				case 5:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 25*qty;
					break;
				case 6:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 25*qty;
					break;
				case 7:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 45*qty;
					break;
				case 8:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 10*qty;
					break;
				case 9:
					System.out.print("Enter quantity : ");
					qty = sc.nextInt();
					total = total + 20*qty;
					break;
				case 10:
					System.out.print("Total : "+total);
					exit = true;
					break;
			}

		}while(!exit);
	}
}