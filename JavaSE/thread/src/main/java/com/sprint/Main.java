package com.sprint;

//不规范的导包方式
import com.sprint.ch02.*;
public class Main {
	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		t.start();
	}
}
