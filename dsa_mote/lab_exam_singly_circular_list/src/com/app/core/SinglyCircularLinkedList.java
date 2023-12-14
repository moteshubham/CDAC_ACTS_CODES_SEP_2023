package com.app.core;

public class SinglyCircularLinkedList {

	private Node head;
	private Node tail;
	private int size;

	private static class Node {
		private Node next;
		private int data;

		Node(int data) {
			this.next = null;
			this.data = data;
		}
	}

	public SinglyCircularLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addAtBegin(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
		} else {

			newNode.next = head;
			head = newNode;
			tail.next = head;

		}
	}

	public void addAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			newNode.next = head;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
			newNode.next = head;
		}
	}

	public void addAtSpecificPosition(int data, int position) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
		} else {
			if (position == 0) {
				newNode.next = head;
				head = newNode;
				tail.next = head;
			} else {
				Node temp = head;
				int counter = 0;
				while (temp != null && counter < position - 1) {
					temp = temp.next;
					counter++;
				}
				if (counter != position - 1) {
					System.out.println("no such ele");
				}
				newNode.next = temp.next;
				temp.next = newNode;
				if (temp == tail) {
					tail = newNode;
				}
			}
		}
	}

	public void printData() {
		if (head == null) {
			System.out.println("empty list");
			return;
		} else {
			Node trav = head;
			do {// must remeber that you NEED DO-WHILE IN CIRCULAR CASE
				System.out.print(trav.data + " --");
				trav = trav.next;
			} while (trav != head);
		}
		System.out.println("head");
	}

	public void printDataRev() {
		printDataRev(head);
	}

	public void printDataRev(Node temp) {

		if (temp == tail) {
			return;
		} else {
			printDataRev(temp.next);
		}
		System.out.print(temp.data + " ");
	}

	// counting no of nodes
	public void countNodes() {
		if (head == null) {
			System.out.println("0");
			return;
		}
		Node trav = head;
		int count = 0;
		do {
			count++;
			trav = trav.next;
		} while (trav != head);
		
		System.out.println("Coutn : " + count);
	}
}
