package tester;



import java.util.Scanner;

import com.app.core.SinglyLinkedList;

public class SinglyLinkedListManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			
			SinglyLinkedList s = new SinglyLinkedList();
			
			
			boolean exit = false;
			while (!exit) {
				System.out.println();
				System.out.println("1. Add Data");
				System.out.println("2. Display Data");
				System.out.println("3. Delete ");
				System.out.println("4. ");
				System.out.println("5. ");
				System.out.println("6. ");
				System.out.println("Choose an option : ");
			
				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						s.addNode(11);
						s.addNode(22);
						s.addNode(33);
						s.addNode(44);
						break;

					case 2:
						sc.nextLine();
						s.printNodes();
						break;

					case 3:
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

