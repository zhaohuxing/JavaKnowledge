package com.sprint.generics;

import com.sprint.utils.Generator;
public class Fibonacci implements Generator<Integer> {
	private int count = 0;

	@Override
	public Integer next() {
		return fib(count++);
	}

	private Integer fib(int n) {
		if (n < 2) return 1;
		return fib(n-1) + fib(n-2);
	} 
}
