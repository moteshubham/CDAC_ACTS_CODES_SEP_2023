package tester;

import com.app.core.*;

import java.util.Scanner;

public class StackManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the size : ");

			int size = sc.nextInt();
			Stack s = new Stack(size);
			boolean exit = false;
			while (!exit) {
				System.out.println("\n1. Push\n" + "2. Pop\n" + "3. isEmpty\n" + "4. isFull\n" + "5. Display all\n"
						+ "6. Peek\n" + "7. Count.\n"+"0. Exit\n" + "Choose an option : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						System.out.println("Enter element to PUSH : ");
						s.push(sc.nextInt());
						sc.nextLine();
						s.display();
						break;

					case 2:
						sc.nextLine();
						System.out.println("Popped element : " + s.pop());
						s.display();
						break;

					case 3:
						if (s.isEmpty()) {
							System.out.println("Stack is already Empty");
						} else {
							System.out.println("Stack is not Empty");
						}
						break;

					case 4:
						if (s.isFull()) {
							System.out.println("Stack is Full");
						} else {
							System.out.println("Stack not Full yet");
						}
						break;

					case 5:
						System.out.println("Elements are : ");
						s.display();
						break;

					case 6:
						System.out.println("Top element is : "  + s.peek());
						break;

					case 7:
						System.out.println("Total count of elements : " + s.count());
						break;

					case 0:
						exit = true;
						System.out.println("byee");
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}
		}

	}

}
