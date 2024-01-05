import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Grocery.GroceryShop;

public class GroceryTester {

	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Map<String, GroceryShop> map=new HashMap<>();
		boolean exit=false;
		while(!exit)
		{
			System.out.println("Choose the operation\n"
					+ "1.Add new grocery item\n"
					+ "2.Update the qty of item\n"
					+ "3.Display the list of grocery items including name,prices and qty\n"
					+ "4.Remove all empty stocks\n"
					+ "5.Display all products for which stock updated in last 3 days\n"
					+ "0.Exit");
			
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("Enter the item details!!");
				GroceryShop g1=new GroceryShop("Soap", 10, 25, LocalDate.parse("2023-10-25"));
				GroceryShop g2=new GroceryShop("Book", 55, 40, LocalDate.parse("2023-10-22"));
				GroceryShop g3=new GroceryShop("Toothpaste", 20, 30, LocalDate.parse("2023-10-15"));
				GroceryShop g4=new GroceryShop("Brush", 20, 15, LocalDate.parse("2023-10-24"));
				GroceryShop g5=new GroceryShop("Milk",28 , 25, LocalDate.parse("2023-10-21"));
				
				map.put(g1.getName(), g1);
				map.put(g2.getName(), g2);
				map.put(g3.getName(), g3);
				map.put(g4.getName(), g4);
				map.put(g5.getName(), g5);
				break;
				
			case 2:
				System.out.println("Enter the item stock to be updated!");
				String name=sc.next();
				int qty=sc.nextInt();
				
				map.get(name).setQtyinStock(qty);
				
				break;
				
			case 3:
				
				map.values().forEach(p->System.out.println(p));
				break;
				
			case 4:
				System.out.println(map.values().removeIf(p-> p.getQtyinStock()==0));
				
				break;
				
			case 5:
				LocalDate lastThreedays=LocalDate.now().minusDays(3);
				
				map.values().stream().filter(p->p.getUpdateTime().isAfter(lastThreedays)).forEach(p->System.out.println(p));;
				break;
				
			case 0:
				exit=true;
				break;
				
			}
			
		}
		
		
		
		
		
		
	}
}
