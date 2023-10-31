package tester;

//delete node pending some working

import java.util.Scanner;

import com.app.core.CircularLinkedList;

public class CircularLinkedListManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			
			CircularLinkedList s = new CircularLinkedList();
			
			
			boolean exit = false;
			while (!exit) {
				System.out.println();
				System.out.println("1. Add Data");
				System.out.println("2. Display Data");
				System.out.println("3. Count ");
				System.out.println("4. --");
				System.out.println("5. --");
				System.out.println("6. --");
				System.out.println("Choose an option : ");
			
				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						System.out.println("Enter element to add");
						s.addNode(sc.nextInt());
					
						break;

					case 2:
						sc.nextLine();
						s.printList();
						break;

					case 3:
						sc.nextLine();
					
						s.countList();
						break;

					case 4:

						break;

					case 5:

						break;

					case 6:

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

