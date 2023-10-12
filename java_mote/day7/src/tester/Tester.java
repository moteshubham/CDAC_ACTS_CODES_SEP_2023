package tester;
import java.util.Scanner;

import stack.*;
public class Tester {

	public static void main(String[] args) {
		
		
		try (Scanner sc = new Scanner(System.in)){
			int counter=0;
			System.out.println("\n\n1. Choose Fixed Stack \n2. Choose Growable Stack \n3. Push Data \n4. Pop Data & Display Name \n5. Exit\n\n");
			
			switch (sc.nextInt()) {
			
			case 1:
				Fixed_Stack[] fixed = new Fixed_Stack[3];
				
				break;
			case 2:
				//GrowableStack[] grows = new GrowableStack()
				break;
			case 3:
				fixed[0] = new Customer(counter++, sc.next(), sc.next());
				fixed[0].push(c);
				break;
			case 4:
				
				break;
			case 5:
				System.exit(0);
				break;

			default:
				break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

}
