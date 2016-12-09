package com.sprint.byteStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopyBytes {
	public void copyBytes(String filenameA, String filenameB) throws IOException {
		/*通过字节流将filenameA里的数据　拷贝到 filenameB*/		
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(filenameA);
			out = new FileOutputStream(filenameB);

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}

			if (out != null) {
				out.close();
			}
		}
	}
}
