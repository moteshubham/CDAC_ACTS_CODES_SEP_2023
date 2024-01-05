package tester;

import java.util.Scanner;

import com.app.core.SinglyLinkedList;

public class Test {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			SinglyLinkedList s = new SinglyLinkedList();
			boolean exit = true;
			while (exit) {
				System.out.println("--------------------");
				System.out.println("1. add data ");
				System.out.println("2. delete data ");
				System.out.println("3. print data ");
				System.out.println("4. add data at end");
				System.out.println("5. delete node at");
				System.out.println("6. display rev");
				System.out.println("enter choice : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("enter data");
					s.addNode(sc.nextInt());
					s.printData();
					break;
				case 2:
					System.out.println("enter data");
					s.deleteNode(sc.nextInt());
					s.printData();
					break;
				case 3:
					System.out.println("printing data");
					s.printData();
					break;
				case 4:
					System.out.println("enter last node");
					s.addAtEnd(sc.nextInt());
					s.printData();
					break;
				case 5:
					System.out.println("enter node index to delete");
					s.deleteNodeAt(sc.nextInt());
					s.printData();
					break;
				case 6:
					System.out.println("reverse data printing");
					s.printDataRev();
					break;
				case 7:
					System.out.println("enter node index to delete");
					s.deleteNodeAt(sc.nextInt());
					s.printData();
					break;
				case 0:
					exit = false;
					break;
				default:
					System.out.println("enter valid choice");
					break;
				}
			}
		}
	}

}
