package com.app.core;

import custom_exceptions.StackEmptyException;
import custom_exceptions.StackFullException;

public class Stack {
	private int top;
	private int size;
	private int[] stack;

	public Stack(int size) {
		this.top = -1;
		this.size = size;
		this.stack = new int[size];
	}

	public void push(int element) throws StackFullException {
		if (isFull()) {
			throw new StackFullException("Stack is Full, can't PUSH");
		}
		top++;
		stack[top] = element;
	}

	public void display() {
		System.out.println("Current stack state : ");
		for (int i : stack) {
			System.out.println(i);
		}
	}

	public int pop() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("Stack is Empty, can't POP");
		}
		int element = stack[top];
		stack[top] = 0;
		top--;
		return element;
	}

	public int peek() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("Stack is Empty, can't POP");
		}
		return stack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == size - 1;
	}

	public int count() {
		int counter = 0;
		for (int i : stack) {
			counter++;
		}
		return counter;
	}
}
