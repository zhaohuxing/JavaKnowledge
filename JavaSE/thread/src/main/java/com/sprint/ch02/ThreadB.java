package com.sprint.ch02;

public class ThreadB extends Thread {
	
	private PublicVar publicVar;
	public ThreadB(PublicVar publicVar) {
		super();
		this.publicVar = publicVar;
	}

	@Override
	public void run() {
		super.run();
		publicVar.setValue("B", "BB");
	}
}
