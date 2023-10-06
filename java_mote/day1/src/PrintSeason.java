import java.util.Scanner;

class PrintSeason
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		boolean exit;
		exit = false;
		
		while(!exit)
		{	
			System.out.print("Enter a number betn 1-12 : ");
			int choice = sc.nextInt();
			switch(choice)
			{ case 1:
			case 2 :
			case 11 : 
			case 12 :  System.out.println("Winter!!!");
			break;
			case 3 :
			case 4 :
			case 5 :
			case 6 : System.out.println("Summer!!!");
			break;
			case 7 :
			case 8 :
			case 9 :
			case 10 : System.out.println("Monsoon!!!");			
			break;
			default :
			exit=true;
			System.out.println("Invalid month , Terminating the app!!!!!");	
			}
		}
	}
}