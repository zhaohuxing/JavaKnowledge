package com.sprint.ch02;

public class ServiceThread extends Thread {
	@Override
	public void run() {
		new Service().service1();
	}
}
