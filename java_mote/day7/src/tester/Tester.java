package tester;

import java.util.Scanner;

import stack.*;

public class Tester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Stack ref = null;
			while (!exit) {
				System.out.println(
						"\n\n1. Choose Fixed Stack \n2. Choose Growable Stack \n3. Push Data \n4. Pop Data & Display Name \n5. Exit\n\n");

				switch (sc.nextInt()) {

				case 1:
					ref = new Fixed_Stack();
					break;

				case 2:
					ref = new GrowableStack();

					break;

				case 3:
					if (ref == null) {
						System.out.println("Choose stack first");
					} else {
						
						if (false){//ref instanceof Fixed_Stack) {
							//Fixed_stack operation push
							System.out.println("in main of fixed_stak");
							if (((Fixed_Stack) ref).getTop() != Fixed_Stack.STACK_SIZE - 1) {
								Customer c = new Customer(sc.nextInt(), sc.next(), sc.next());
								ref.push(c);
							} else {
								System.out.println("Stack full!!!");
							}
						} else {
							System.out.println("main() : push() : growable");
							// growable stack push method here
							if (((GrowableStack) ref).getTop() != ((GrowableStack) ref).getTopTop() - 1) {
								System.out.println("main() : growable() : IFFF");
								Customer c = new Customer(sc.nextInt(), sc.next(), sc.next());
								ref.push(c);
							} else {
								System.out.println("main() : growable() : calling pushgrow()");
								Customer c = new Customer(sc.nextInt(), sc.next(), sc.next());
								((GrowableStack)ref).pushGrow(c);
							}
						}
					}
					break;

				case 4:
					if (ref == null) {
						System.out.println("Choose stack first");
					} else {
						if (ref instanceof Fixed_Stack) {
							if (((Fixed_Stack) ref).getTop() != -1) {
								System.out.println(ref.pop());
							} else {
								System.out.println("Stack empty already");
							}
						} else {
							// growable sta'ck pop method here
						}
					}
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
