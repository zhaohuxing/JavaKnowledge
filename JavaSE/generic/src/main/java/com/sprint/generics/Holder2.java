package com.sprint.generics;

public class Holder2 {
	private Object obj;
	public Holder2(Object obj) {
		this.obj = obj;
	} 
	public void set(Object obj) {
		this.obj = obj;
	}
	public Object get() {
		return obj;
	}
}
