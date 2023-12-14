package com.app.core;

public class SinglyLinkedList {

	private Node head;
	private int size = 0;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public SinglyLinkedList() {
		head = null;
	}

	public void addNode(int data) {
		// make node for the incoming data
		Node newNode = new Node(data);
		if (head == null) {
			// add first element
			head = newNode;
			size += 1;
		} else {
			// add further elements
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			size += 1;
		}
	}

	public void addAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode; // added at last
			size += 1;
		}
	}

	// deleting node by data valueee
	public void deleteNode(int data) {
		if (head == null) {
			System.out.println("list empty");
		} else if (head.next == null) {
			head = null;
			size -= 1;
		} else {
			Node temp = head;
			if (head.data == data) {
				head = head.next;
			} else {
				while (temp.next.data != data) {
					temp = temp.next;
				}
			}
			temp.next = temp.next.next;
			size -= 1;
		}
	}

	// delete at specific position
	public void deleteNodeAt(int index) {
		if (index <= 1) {
			head = head.next;
		} else if (index > size) {
			System.out.println("invalid index");
		} else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;

		}
	}

	public void printData() {
		System.out.println("-----------------");
		System.out.println("SIZE : " + size);
		System.out.println("-----------------");
		if (head == null) {
			System.out.println("list is empty");
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " - ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	//displaying the data in reversse order
	public void printDataRev() {
		printDataRev(head);
		System.out.println();
	}

	public void printDataRev(Node temp) {
		System.out.println("-----------------");
		System.out.println("SIZE : " + size);
		System.out.println("-----------------");

		if (temp == null) {
			return;
		} else {
			printDataRev(temp.next);
		}
		System.out.print(temp.data+ " - ");
	}

	
	
}
