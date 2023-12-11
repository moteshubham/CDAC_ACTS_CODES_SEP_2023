package com.app.core;

public class SinglyLinkedList {

	private Node head;

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
		} else {
			// add further elements
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void deleteNode(int data) {
		if (head == null) {
			System.out.println("list empty");
		} else if (head.next == null) {
			head = null;
		} else {
			Node temp = head;
			while (temp.next.data != data) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
	}

	public void printData() {
		if (head == null) {
			System.out.println("list is empty");
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " - ");
				temp=temp.next;
			}
			System.out.println();
		}
	}

}
