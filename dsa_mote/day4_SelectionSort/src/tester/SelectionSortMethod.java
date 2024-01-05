package tester;

import java.util.Scanner;

import com.app.core.SelectionSort;

public class SelectionSortMethod {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			SelectionSort s = new SelectionSort();
			System.out.println("Enter how size of array? ");
//			int arr[] = new int[sc.nextInt()];
//			s.addElement(arr, sc);

			int[] arr = { 40, 23, 50, 3, 1, 78, 2, 34, 100 };
			s.displayArray(arr);
			boolean exit = false;
			while (!exit) {
				System.out.println("\n");
				System.out.println("1. Selection Sort ");
				System.out.println("2. Display Array");
//				System.out.println("3. Bubble Sort ");
//				System.out.println("4. ");
//				System.out.println("5. ");
//				System.out.println("6. ");
				System.out.println("Choose an option : ");

				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						System.out.println("Selection Sorted Array : ");
						s.selectionSort(arr);
						System.out.println("\n");
						s.displayArray(arr);
						break;

					case 2:
						sc.nextLine();
						s.displayArray(arr);
						break;

					case 3:
						sc.nextLine();

						break;

					case 4:

						break;

					case 5:

						break;

					case 6:

						break;

					case 0:
						exit = true;
						System.out.println("Byee");
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}
		}

	}

}
