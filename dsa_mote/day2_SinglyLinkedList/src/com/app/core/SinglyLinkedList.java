package com.app.core;

import custom_exceptions.EmptyListException;

public class SinglyLinkedList {

	private Node head;

	public static class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node traverseNode = head;
			while (traverseNode.next != null) {
				traverseNode = traverseNode.next;
			}
			traverseNode.next = newNode;
		}
	}

	public void printNodes() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Emptty List");
		} else {
			Node tempNode = head;
			while (tempNode != null) {
				System.out.println(tempNode.data + " ");
				tempNode = tempNode.next;
			}
		}
	}

	public void deleteNode(int index) throws EmptyListException {
		index = index - 1;
		if (head == null) {
			throw new EmptyListException("Emptty List");
		} else if (head.next == null) {
			head = null;
		} else {
			Node tempNode = head;
			for (int i = 0; i < index - 1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
		}
	}
}
