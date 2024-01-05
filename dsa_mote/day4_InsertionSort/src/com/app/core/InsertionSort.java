package com.app.core;

import java.util.Scanner;

public class InsertionSort {

	public void addElement(int[] arr, Scanner sc) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter element to add");
			arr[i] = sc.nextInt();
		}
	}

	public void displayArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println("\n");
	}

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j] = key;
		}
	}
}
