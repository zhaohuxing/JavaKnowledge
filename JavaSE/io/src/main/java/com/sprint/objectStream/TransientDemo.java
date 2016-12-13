package com.sprint.objectStream;

import java.io.*;
public class TransientDemo {
	public static void testTransient() throws Exception {
		Login a = new Login("fuck", "myLitterPony");
		System.out.println("login a = " + a);

		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("login.out"));
		o.writeObject(a);
		o.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("login.out"));
		a = (Login)in.readObject();
		System.out.println("Login a = " + a);

	}	
}
