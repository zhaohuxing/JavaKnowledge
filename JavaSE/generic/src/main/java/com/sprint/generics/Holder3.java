package com.sprint.generics;

public class Holder3<T> {
	private T t;
	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}
