package com.app.core;

import custom_exceptions.EmptyListException;

public class DoublyLinkedList {

	private Node head;
	private Node tail;

	public DoublyLinkedList() {
		super();
		this.head = null;
		this.tail = null;
	}

	private static class Node {
		private int data;
		private Node next;
		private Node prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} 
		else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;			
		}
	}

	public boolean isEmpty() {
		return head == null;
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
