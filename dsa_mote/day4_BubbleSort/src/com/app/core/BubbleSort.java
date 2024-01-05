package com.app.core;

import java.util.Scanner;

public class BubbleSort {

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

	public void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
