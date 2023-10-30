package com.app.core;

import custom_exceptions.QueueEmptyException;
import custom_exceptions.QueueFullException;

//import custom_exceptions.queueEmptyException;
//import custom_exceptions.queueFullException;

public class CircularQueue {
	private int front;
	private int rear;
	private int size;
	private int[] queue;

	public CircularQueue(int capacity) {
		this.front = 0;
		this.rear = 0;
		this.size = capacity;
		this.queue = new int[capacity];
	}

	public void enqueue(int element) throws QueueFullException {
		if (isFull()) {
			throw new QueueFullException("Queue is full bro");
		}
		rear = (rear + 1) % size;
		queue[rear] = element;
	}

	public int dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is already Empty");
		}
		front = (front + 1) % size;
		int element = queue[front];
		queue[front] = 0;
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
		return rear == front;
	}

	public boolean isFull() {
		
		return rear >= (front)%size;
	}
}
