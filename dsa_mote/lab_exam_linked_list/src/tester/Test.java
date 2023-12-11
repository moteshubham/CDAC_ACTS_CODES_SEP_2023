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
				System.out.println("enter choice : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("enter data");
					s.addNode(sc.nextInt());
					break;
				case 2:
					System.out.println("enter data");
					s.deleteNode(sc.nextInt());
					break;
				case 3:
					System.out.println("printing data");
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
