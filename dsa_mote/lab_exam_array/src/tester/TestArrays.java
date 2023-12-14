package tester;

import java.util.Iterator;
import java.util.Scanner;

public class TestArrays {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the capacity of the array");
			int[] array = new int[sc.nextInt()];
			
			System.out.println("enter elements");
			for (int i = 0; i < array.length; i++) {
				 array[i] = sc.nextInt();
				
			}
			
			
			
			boolean done = false;
			while (!done) {
				System.out.println("1. Display the array");
				System.out.println("2. Reverse the array");
				System.out.println("3. Replace the nth element from the array and print");
				System.out.println("4. Find the addition of all elements of the array");
				System.out.println("5. Find the maximum number from the array");
				System.out.println("6. Print the average of all the elements from the array.");
				System.out.println("7. Display the even and odd number from the array separately.");
				System.out.println("0. EXIT");
				System.out.println("Enter the choice");
				switch (sc.nextInt()) {
				case 1:// display
					display(array);
					break;
				case 2:
					//reverse(array);
					break;
				case 3:
					System.out.println("Enter the position and elements wants to replace");
				//	replace(array, sc.nextInt(), sc.nextInt());
					break;
				case 4:
					System.out.println("Addition of all elements in array " + addition(array));
					break;
				case 5:
					System.out.println("Maximum  element in array " + maximum(array));
					break;
				case 6:
					System.out.println("Average of all elements in array is " + average(array));
					break;
				case 7:
					System.out.println("Display the even and odd numbers from array");
					oddEven(array);
					break;

				case 0:
					done = true;
					System.out.println("Bye");
					break;
				default:
					System.out.println("Enter Valid Choice");

				}
			}

		}

	}