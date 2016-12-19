package com.sprint.bufferedStreams;

import java.io.*;
public class BasicFileOutput {
	public static void printf(String filename, String file) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(filename)));
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while ((s = in.readLine()) != null)
			out.println(lineCount++ + ":" + s );
		out.close();
	}
}
