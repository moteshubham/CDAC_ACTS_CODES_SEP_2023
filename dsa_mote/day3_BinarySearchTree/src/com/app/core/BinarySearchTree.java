package com.app.core;

public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	private class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void insertNode(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		} else {
			insertNode(root, newNode);
		}
	}

	private void insertNode(Node node, Node newNode) {
		if (newNode.data < node.data) {
			if (node.left == null) {
				node.left = newNode;
			} else {
				insertNode(node.left, newNode);
			}
		} else {
			if (node.right == null) {
				node.right = newNode;
			} else {
				insertNode(node.right, newNode);
			}
		}
	}

	public void inorderTraversal() {
		inorderTraversal(root);
	}

	private void inorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left);
		System.out.println(node.data);
		inorderTraversal(node.right);
	}

//------------------------------------------------------
	public void preorderTraversal() {
		preorderTraversal(root);
	}

	private void preorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}

//------------------------------------------------------
	public void postorderTraversal() {
		postorderTraversal(root);
	}

	private void postorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.data);
	}

}
