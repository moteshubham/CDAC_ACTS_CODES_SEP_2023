package com.app.core;

import custom_exceptions.EmptyListException;

public class CircularLinkedList {

	private Node head;

	public static class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			Node traverseNode = head;
			while (traverseNode.next != head) {
				traverseNode = traverseNode.next;
			}
			traverseNode.next = newNode;
			newNode.next = head;
		}
	}

	public void printList() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Emptty List");
		} else {
			Node traverseNode = head;
			do {
				System.out.println(traverseNode.data + " ");
				traverseNode = traverseNode.next;
			}while (traverseNode != head);
		}
	}
	
	public void countList() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Emptty List : 0 elements");
		} else {
			Node traverseNode = head;
			int counter = 0;
			do {
				counter++;
				
				traverseNode = traverseNode.next;
			}while (traverseNode != head);
			System.out.println( "Count is  : " + counter);
		}
	}
//
//	public void deleteNode(int index) throws EmptyListException {
//		index = index - 1;
//		if (head == null) {
//			throw new EmptyListException("Emptty List");
//		} else if (head.next == null) {
//			head = null;
//		} else {
//			Node traverseNode = head;
//			for (int i = 0; i < index - 1; i++) {
//				traverseNode = traverseNode.next;
//			}
//			traverseNode.next = traverseNode.next.next;
//		}
//	}
}
