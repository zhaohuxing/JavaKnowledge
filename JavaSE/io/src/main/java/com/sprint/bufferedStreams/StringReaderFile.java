package com.sprint.bufferedStreams;

import java.io.*;
public class StringReaderFile {
	public static void read(String filename) throws IOException {
		StringReader in = new StringReader(BufferedInputFile.read(filename)); 	
		int c;
		while ((c = in.read()) != -1) {
			System.out.println((char)c);
		}
	}
}
