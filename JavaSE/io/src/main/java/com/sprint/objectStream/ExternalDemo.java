package com.sprint.objectStream;
import java.io.*;
public class ExternalDemo {
	public static void testExternal() throws IOException, ClassNotFoundException {
		System.out.println("创建对象");
		Bilp bilp = new Bilp("A String", 47);
		System.out.println(bilp);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip.out"));
		System.out.println("存储序列化的对象:");
		o.writeObject(bilp);
		o.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip.out"));
		System.out.println("读取，将字节序列反序列化成对象");
		bilp = (Bilp)in.readObject();
		System.out.println(bilp);
	}
}
