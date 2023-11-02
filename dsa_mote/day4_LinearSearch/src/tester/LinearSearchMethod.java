package tester;

import java.util.Arrays;
import java.util.Scanner;

import com.app.core.LinearSearch;

public class LinearSearchMethod {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			LinearSearch s = new LinearSearch();
			System.out.println("Enter how many elements? ");
			int arr[] = new int[sc.nextInt()];

			boolean exit = false;
			while (!exit) {
				System.out.println("\n");
				System.out.println("1. Add Data to Array");
				System.out.println("2. Display Array");
				System.out.println("3. Linear Search ");
//				System.out.println("4. ");
//				System.out.println("5. ");
//				System.out.println("6. ");
				System.out.println("Choose an option : ");

				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();

						s.addElement(arr, sc);
						// Arrays.sort(arr); Linear sort can be used and sorted or unsorted arrays
						s.displayArray(arr);
						break;

					case 2:
						sc.nextLine();
						s.displayArray(arr);
						break;

					case 3:
						sc.nextLine();
						System.out.println("Enter element to search");
						int toSearch = sc.nextInt();
						s.linearSearch(arr, toSearch);
						System.out.println("\n");
						s.displayArray(arr);
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
