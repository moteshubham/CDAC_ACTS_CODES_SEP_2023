package tester;
import java.util.Scanner;

import stack.*;
public class Tester {

	public static void main(String[] args) {
		
		
		try (Scanner sc = new Scanner(System.in)){
			boolean exit = false;;
			Stack ref = new Fixed_Stack();
			while(!exit) {
			System.out.println("\n\n1. Choose Fixed Stack \n2. Choose Growable Stack \n3. Push Data \n4. Pop Data & Display Name \n5. Exit\n\n");
			
			switch (sc.nextInt()) {
			
			case 1:
				
				break;
			case 2:
				//GrowableStack[] grows = new GrowableStack()
				break;
			case 3:
				Customer c = new Customer(sc.nextInt(), sc.next(), sc.next());
				ref.push(c);
				break;
			case 4:
				
				System.out.println(ref.pop());
				break;
			case 5:
				System.exit(0);
				break;

			default:
				break;
			}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

}
