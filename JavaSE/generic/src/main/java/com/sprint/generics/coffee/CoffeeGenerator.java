package com.sprint.generics.coffee;

import com.sprint.utils.*;
import java.util.*;
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	private Class[] types = {Americano.class, Breve.class, Cappuccino.class,
		Latte.class, Mocha.class};	
	private Random random = new Random(47);
	public CoffeeGenerator() {
		
	}

	private int size = 0;
	public CoffeeGenerator(int size) {
		this.size = size;
	}

	@Override
	public Coffee next() {
		try {
			return (Coffee)
				types[random.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;
		
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}
	}
}

/**
 *	实现Iterator必须实现boolean hasNext(), E next()这两个接口，remove和forEachRemaing方法不一定默认实现。
 * */
