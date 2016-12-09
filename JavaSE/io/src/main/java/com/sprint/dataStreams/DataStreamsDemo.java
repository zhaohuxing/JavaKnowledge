package com.sprint.dataStreams;

import java.io.*;
public class DataStreamsDemo {
	//private static final String dataFile = "dataStreams.txt";
	private static final double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
	private static final int[] units = {12, 8, 13, 29, 50};
	private static final String[] descs = {
		"Java T-shirt",
		"Java Mug",
		"Duke Juggling Dolls",
		"Java Pin",
		"Java Key Chain"
	};

	public static void writeData(String dataFile) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
		//for (int i = 0; i < prices.length; i++) {
		//	out.writeDouble(prices[i]);
		//	out.writeInt(units[i]);
		//	out.writeUTF("sss");
		//}	
		out.writeUTF("xxx");
	}

	public static void readData(String dataFile) throws IOException {
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
		System.out.println(in.readUTF());
	}
}
