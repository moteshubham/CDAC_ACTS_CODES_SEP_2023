package com.app.core;

import java.util.Scanner;

public class BinarySearch {

	public void addElement(int[] arr, Scanner sc) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter element to add");
			arr[i] = sc.nextInt();
		}
	}

	public void displayArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}

	public void binarySearch(int[] arr, int toSearch) {

		int low = 0;
		int high = arr.length - 1;
		int mid = (low + high) / 2;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("iteration : " + (i + 1));
			if (arr[mid] == toSearch) {
				System.out.print("Element found at index =>> " + (mid + 1));
				return;
			} else if (toSearch < arr[mid]) {
//				low = 0;
				high = mid - 1;
			} else {
				low = mid + 1;
//				high = arr.length;
			}
			mid = (low + high) / 2;
		}
		System.out.println("Element not found");
	}

}
