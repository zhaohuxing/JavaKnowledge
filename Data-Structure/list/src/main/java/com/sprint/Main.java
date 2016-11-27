package com.sprint;

import java.util.Iterator;
import com.sprint.list.MyArrayList;
import com.sprint.list.MyLinkedList;
import com.sprint.stack.ListStack;
import com.sprint.stack.ArrayStack;
import com.sprint.queue.ListQueue;
public class Main {
	public static void main(String[] args) {
		System.out.println("测试MyArrayList:");
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		for (int i = 0; i < 5; i++)
			myArrayList.add(i);

		for (int val : myArrayList)
			System.out.print(val + " ");
		Iterator arrayTest = myArrayList.iterator();
		while(arrayTest.hasNext()) {
			System.out.print(arrayTest.next() + " " );
		}
		System.out.println("\n测试MyLinkedList:");	
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		for (int i = 0; i < 5; i++)
			myLinkedList.add(i);

		for (int val : myLinkedList)
			System.out.print(val + " ");
		Iterator linkTest = myLinkedList.iterator();
		while (linkTest.hasNext()) {
			System.out.print(linkTest.next() + " ");
		}

		System.out.println("\n测试ListStack:");
		ListStack<Integer> listStack = new ListStack<Integer>();
		for (int i = 0; i < 5; i++) {
			listStack.push(i);
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.print(listStack.pop() + " ");	
		}

		System.out.println("\n测试ArrayStack:");
		ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
		for (int i = 0; i < 5; i++) {
			arrayStack.push(i);
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(arrayStack.pop() + " ");
		}

		System.out.println(arrayStack.isEmpty());

		System.out.println("\n测试ListQueue:");
		ListQueue<Integer> listQueue = new ListQueue<Integer>();
		for (int i = 0; i < 5; i++) {
			listQueue.enQueue(i);	
		}

		for (int i = 0; i < 5; i++) {
			System.out.print(listQueue.deQueue() + " ");
		}
		System.out.println("listQueue is empty ? " + listQueue.isEmpty());
	}
}
