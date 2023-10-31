package tester;

import java.util.Scanner;

import com.app.core.CircularDoublyLinkedList;

public class CircularDoublyLinkedListManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			CircularDoublyLinkedList s = new CircularDoublyLinkedList();

			boolean exit = false;
			while (!exit) {
				System.out.println();
				System.out.println("1. Add Data");
				System.out.println("2. Display Data");
				System.out.println("3. ");
				System.out.println("4. ");
				System.out.println("5. ");
				System.out.println("6. ");
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
						s.printNodes();
						break;

					case 3:
						sc.nextLine();
						System.out.println("Enter element index to delete");
						// s.deleteNode(sc.nextInt());
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
