package com.app.core;

import custom_exceptions.QueueEmptyException;
import custom_exceptions.QueueFullException;

//import custom_exceptions.queueEmptyException;
//import custom_exceptions.queueFullException;

public class SimpleQueue {
	private int front;
	private int rear;
	private int size;
	private int[] queue;

	public SimpleQueue(int capacity) {
		this.front = -1;
		this.rear = -1;
		this.size = capacity;
		this.queue = new int[capacity];
	}

	public void enqueue(int element) throws QueueFullException {
		if (isFull()) {
			throw new QueueFullException("Queue is Full");
		}
		rear++;
		queue[rear] = element;
		if (front == -1) {
			front = 0;
		}
	}

	public int dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is already Empty");
		}
		int element = queue[front];
		queue[front] = 0;
		front++;
		return element;
	}

	public void display() {
		System.out.println("Current queue state : ");
		for (int i : queue) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("------------------------------------------");
	}

	public int front() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is already Empty");
		}
		return queue[front];
	}

	public int rear() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is already Empty");
		}
		return queue[rear];
	}

	public boolean isEmpty() {
		return rear == -1 || front > rear;
	}

	public boolean isFull() {
		System.out.println(rear + "  " + size);
		return rear == size - 1;
	}
}
