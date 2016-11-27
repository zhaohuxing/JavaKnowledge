package com.sprint.stack;

public class ListStack<AnyType> {

	private Node<AnyType> currentNode;
	private int size;

	private static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> nextNode;

		public Node(AnyType data, Node<AnyType> nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
	}

	public ListStack() {
		clear();
	}

	public void clear() {
		size = 0;
		currentNode = new Node<AnyType>(null, null);
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	public void push(AnyType x) {
		Node<AnyType> newNode = new Node<AnyType>(x, currentNode);
		currentNode = newNode;
		size++;
	}

	public AnyType pop() {
		Node<AnyType> oldNode = currentNode;
		currentNode = oldNode.nextNode;
		size--;
		return 	oldNode.data;
	}
} 
