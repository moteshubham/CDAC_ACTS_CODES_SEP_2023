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
			Node traverseNode = head;
			while (traverseNode != null) {
				System.out.println(traverseNode.data + " ");
				traverseNode = traverseNode.next;
			}
		}

	}
}
