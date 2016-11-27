package com.sprint.list;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	
	/*记录链表的容量*/
	private int theSize;
	
	private int modCount = 0;
	
	/*记录*/
	private Node<AnyType> beginMarker;
	
	/*后继节点*/
	private Node<AnyType> endMarker;

	/*节点*/
	private static class Node<AnyType> {
		
		/*存放的数据*/
		public AnyType data;
		
		/*前驱节点*/
		public Node<AnyType> prev;
		
		/*后继节点*/
		public Node<AnyType> next;

		/*构造实例*/
		public Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	/*初始化空链表*/
	public MyLinkedList() {
		clear();
	}

	/*
	 * 双向链表的特点：头节点的前驱节点为null，尾节点的后继节点为null.
	 * 创建头节点，尾节点，并将两端置空,且将连接起来．
	 * ｛［pre:null］[head][next:tail]} < --- >{ [pre:head][tail][next:null]}
	 * 将添加的数据至于之间
	 * ｛［pre:null］[head][next:tail]} < -......-- >{ [pre:head][tail][next:null]}
	 * */
	public void clear() {
		beginMarker = new Node<AnyType>(null, null, null);
		endMarker = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMarker;

		theSize = 0;
		modCount++;
	}

	/*获取链表大小*/
	public int size() {
		return theSize;
	}

	/*判断链表是否为空*/
	public boolean isEmpty() {
		return size() == 0;
	}

	/*获取该节点上的数据*/
	public AnyType get(int idx) {
		return getNode(idx).data;
	}

	/*设置链表idx位置的节点的值*/
	public AnyType set(int idx, AnyType newVal) {
		Node<AnyType> p = getNode(idx);
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}


	/*通过add(size(),x) 向链尾添加元素x*/
	public boolean add(AnyType x) {
		add(size(), x);
		return true;
	}

	/*在链表idx位置插入x*/
	public void add(int idx, AnyType x) {
		addBefore(getNode(idx), x);
	}

	/*通过新节点的后继节点(即idx位置的旧节点)来插入新节点*/
	private void addBefore(Node<AnyType> p, AnyType x ) {
		Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}

	/*通过在链表中位置删除idx节点*/
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	
	/*删除节点p*/
	private AnyType remove(Node<AnyType> p) {
		p.next.prev = p.prev;
		p.prev = p.next;
		theSize--;
		modCount++;
		return p.data;
	}

	/*虽然链表存储地址不是按序，但是node位于链表上的那个位置是有序的，
	 * 所以按照位次查询*/
	private Node<AnyType> getNode(int idx) {
		Node<AnyType> p;
		if (idx < 0 || idx > size())
			throw new IndexOutOfBoundsException();

		if (idx < size() /2) {
			p = beginMarker.next;
			for (int i = 0; i < idx; i++)
				p = p.next;
		} else {
			p = endMarker;
			for (int i = size(); i > idx; i--)
				p = p.prev;
		}
		return p;
	}

	@Override
	public java.util.Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements java.util.Iterator<AnyType> {
		
		/*默认当前节点是链表的head*/
		private Node<AnyType> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;

		/*判断是否还有节点*/
		public boolean hasNext() {
			return current != endMarker;
		}

		/*获取节点*/
		public AnyType next() {
			if (modCount != expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			AnyType nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}

		/*删除节点*/
		public void remove() {
			if (modCount != expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if (!okToRemove)
				throw new IllegalStateException();

			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}
	}
}
