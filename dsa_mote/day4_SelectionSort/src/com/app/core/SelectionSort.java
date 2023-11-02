package com.app.core;

import java.util.Scanner;

public class SelectionSort {

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

	public void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i] ;
					arr[i] = temp;
				}
			}
		}
	}

}
