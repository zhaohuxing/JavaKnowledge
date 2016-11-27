package com.sprint.stack;

public class ArrayStack<AnyType> {
	private static final int DEFAULT_CAPACITY = 10; 
	
	private AnyType[] data;
	private int current;
	private int size;

	public ArrayStack() {
		clear();
	}

	public void clear() {
		ensureCapacity(DEFAULT_CAPACITY);
		size = 0;
		current = 0;
	}
	
	public int size() {
		return size;
	}

	public void ensureCapacity(int newCapacity) {
		if (size > newCapacity)
			return;
		AnyType[] old = data;
		data = (AnyType[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++) 
			data[i] = old[i];
	}

	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void push(AnyType x) {
		data[current] = x;
		size++;
		current++;
	}

	public AnyType pop() {
		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		AnyType	old = data[--current];
		return old;
	}
}
