package com.app.core;

import custom_exceptions.EmptyListException;

public class StackUsingLinkedList {

	private Node head;
	private Node top;

	public static class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {

			newNode.next = head;
			top = head;
			head = newNode;
			
		}
	}

	public void printNodes() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Emptty List");
		} else {
			Node traverseNode = head;
			while (traverseNode != null) {
				System.out.println(traverseNode.data + " ");
				traverseNode = traverseNode.next;
			}
		}
	}

	public void pop() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Emptty List");
		} else {
			System.out.println(head.data);
			top = head.next;
			head = top;
			
		}
	}
}
