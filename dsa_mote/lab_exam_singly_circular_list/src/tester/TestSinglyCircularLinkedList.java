package tester;


import java.util.Scanner;

import com.app.core.SinglyCircularLinkedList;

public class TestSinglyCircularLinkedList {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			SinglyCircularLinkedList s = new SinglyCircularLinkedList();
			boolean exit = true;
			while (exit) {
				System.out.println("--------------------");
				System.out.println("1. add data at begining ");
				System.out.println("2. add data at end ");
				System.out.println("3. print data ");
				System.out.println("4. add data at end");
				System.out.println("5. enter node index to add");
				System.out.println("6. display rev");
				System.out.println("enter choice : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("enter data addAtBegin");
					s.addAtBegin(sc.nextInt());
					s.printData();
					break;
				case 2:
					System.out.println("enter data addAtEnd");
					s.addAtEnd(sc.nextInt());
					s.printData();
					break;
				case 3:
					System.out.println("printing data");
					s.printData();
					break;
				case 4:
					System.out.println("enter last node");
				//	s.addAtEnd(sc.nextInt());
					s.printData();
					break;
				case 5:
					System.out.println("enter (data, node index) to add at that index");
					s.addAtSpecificPosition(sc.nextInt(), sc.nextInt());
					s.printData();
					break;
				case 6:
					System.out.println("reverse data printing");
					s.printDataRev();
					break;
				case 7:
					System.out.println("countNodes");
					s.countNodes();
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
