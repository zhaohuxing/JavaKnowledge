package com.sprint.bufferedStreams;

import java.io.*;
public class StoringAndRecoveringData {
	public static void printf(String filename) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
		out.writeDouble(3.141592);
		out.writeUTF("I Love you body");
		out.writeDouble(19951211);
		out.writeUTF("tiger birthday");
		out.close();

		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
	}
}
