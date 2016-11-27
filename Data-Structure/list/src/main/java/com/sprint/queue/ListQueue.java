package com.sprint.queue;

public class ListQueue<AnyType> {
	
	private Node<AnyType> frontNode;
	private Node<AnyType> rearNode;
	private Node<AnyType> currentNode;
	private int size;

	public ListQueue() {
		clear();
	}

	public void clear() {
		frontNode = new Node<AnyType>(null, null);
		rearNode = new Node<AnyType>(null, null);
		frontNode.nextNode = rearNode;
		currentNode = frontNode;
		size = 0;
	}

	public void enQueue(AnyType x) {
		Node<AnyType> newNode = new Node<AnyType>(x, rearNode);
		currentNode.nextNode = newNode;
		currentNode = newNode;
		size++;
	}
	
	public boolean isEmpty() {
		return frontNode.nextNode == rearNode;
	}

	public AnyType deQueue() {
		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		Node<AnyType> old = frontNode.nextNode;
		frontNode.nextNode = old.nextNode;
		size--;
		return old.data;
	}

	public int size() {
		return size;
	}

	private static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> nextNode;

		public Node(AnyType data, Node<AnyType> nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
	}
}
