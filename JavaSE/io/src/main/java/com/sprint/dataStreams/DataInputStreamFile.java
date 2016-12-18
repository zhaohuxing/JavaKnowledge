package com.sprint.dataStreams;

import com.sprint.bufferedStreams.*;
import java.io.*;
public class DataInputStreamFile {
	public static void read(String filename) throws IOException {
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(filename).getBytes()));
		while(in.available() != 0)// in.available在没有阻塞的情况下使用,所以谨慎使用
			System.out.println((char)in.readByte());
	}
}
