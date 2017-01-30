package com.sprint.generics;

import java.util.Iterator;
public class IterableFibonacci 
extends Fibonacci implements Iterable<Integer> {
	private int n;
	
	public IterableFibonacci(int count) {
		n = count;
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return n > 0;	
			}

			@Override
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();//继承父类的
			}
		};
	}
}
