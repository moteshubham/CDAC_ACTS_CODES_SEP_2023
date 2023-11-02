package com.app.core;

import java.util.Scanner;

public class LinearSearch {

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
	}

	public void linearSearch(int[] arr, int toSearch) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == toSearch) {
				System.out.print("Element found at index =>> " + (i+1));
				return;
			}
		}
		System.out.println("Element not found");
	}

}
