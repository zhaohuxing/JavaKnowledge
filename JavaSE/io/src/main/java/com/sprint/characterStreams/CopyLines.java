package com.sprint.characterStreams;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CopyLines {
	public static void copyLines(String filenameA, String filenameB) throws IOException {
		try (BufferedReader inputStream = new BufferedReader(new FileReader(filenameA));
				PrintWriter outputStream = new PrintWriter(new FileWriter(filenameB));) {
		
			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
		}
	}
}
