package tester;

import com.app.core.*;

import java.util.Scanner;

public class SimpleQueueManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the size : ");

			int size = sc.nextInt();
			SimpleQueue q = new SimpleQueue(size);
			boolean exit = false;
			while (!exit) {
				System.out.println("\n\n1. Enqueue\n" + "2. Dequeue\n" + "3. Front \n" + "4. Rear\n" + "5. isEmpty\n"
						+ "6. Display all\n" + "7. Count.\n" + "0. Exit\n" + "Choose an option : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						System.out.println("Enter element to Enqueue : ");
						q.enqueue(sc.nextInt());
						sc.nextLine();
						q.display();
						break;

					case 2:
						//sc.nextLine();
						System.out.println("Dequeue element : " + q.dequeue());
						q.display();
						break;

					case 3:
						System.out.println("Front element is : " + q.front());
						break;

					case 4:
						System.out.println("Rear element is : " + q.rear());
						break;

					case 5:
						if (q.isEmpty()) {
							System.out.println("Queue is Empty");
						} else {
							System.out.println("Queue is not Empty");
						}
						break;

					case 6:
						System.out.println("Elements are : ");
						q.display();
						break;

					case 0:
						exit = true;
						System.out.println("byee");
					}

				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
	}
}
