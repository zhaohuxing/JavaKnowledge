package com.sprint.queue;

public class ArrayQueue<AnyType> {
	private int DEFAULT_CAPACITY = 10;
	private AnyType[] data;
	private int front;
	private int rear;
	private int size;
	
	public ArrayQueue() {
		clear();
	}

	public void clear() {
		size = 0;
		ensureCapacity(DEFAULT_CAPACITY);
		front = 0;
		rear = 0;
		current = front;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public void enQueue(AnyType x) {
		if (size == DEFAULT_CAPACITY - 1) {
			DEFAULT_CAPCITY *= 2;
			ensureCapacity(DEFAULT_CAPACITY);
		}

		data[rear++] = x;
		size++;
	}
	
	public AnyType deQueue() {
		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		AnyType old = data[front];
		front++;
		size--;
		return old;
	}

	public void ensureCapacity(int newCapacity) {
		if (size > newCapacity)
			return;
		AnyType[] old = data;
		data = (AnyType[])new Object[newCapacity];
		for (int i = 0; i < size(); i++) {
			data[i] = old[i];
		}
	}
}
