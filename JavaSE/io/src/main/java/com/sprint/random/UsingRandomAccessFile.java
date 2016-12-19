package com.sprint.random;

import java.io.*;
public class UsingRandomAccessFile {
	public static void printf(String filename) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filename, "r");
		for (int i = 0; i < 7; i++)
			System.out.println(rf.readUTF());
	}

	public static void write(String filename) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filename, "rw");
		for (int i = 0; i < 7; i++) 
			rf.writeUTF("xxx" + i);
	}
}
