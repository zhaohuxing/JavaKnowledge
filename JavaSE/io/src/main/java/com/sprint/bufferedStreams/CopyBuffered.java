package com.sprint.bufferedStreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class CopyBuffered {
	public static void copyBuffered(String filenameA, String filenameB) throws IOException {
		try (BufferedReader inputStream = new BufferedReader(new FileReader(filenameA));
				BufferedWriter outputStream = new BufferedWriter(new FileWriter(filenameB));) {
				int c;

				while((c = inputStream.read()) != -1) {
					outputStream.write(c);	
				}
			
		}
	}
}
