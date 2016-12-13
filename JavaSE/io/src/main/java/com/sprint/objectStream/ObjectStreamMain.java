package com.sprint.objectStream;

import java.io.*;
public class ObjectStreamMain {

	public static void testObjectStream() throws IOException, ClassNotFoundException {
		Worm w = new Worm(6, 'a');
		System.out.println("w = " + w);

		/*将对象序列化存储到磁盘,　在磁盘上读取并反序列化对象*/
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.txt"));
		out.writeObject("Worn storage in Disl:\n");
		out.writeObject(w);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.txt"));
		String s = (String)in.readObject();
		Worm w2 = (Worm)in.readObject();
		System.out.println(s + "w2 = " + w2 );

		/*将对象序列化存储到内存，读取内存中数据将其反序列化成对象*/
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Worn storge in memory:\n");
		out2.writeObject(w);
		out2.flush();

		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		s = (String)in2.readObject();
		Worm w3 = (Worm)in2.readObject();
		System.out.println(s + "w3" + w3 );
	}
}
