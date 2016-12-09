package com.sprint.test;
import java.io.*;
public class Picture {
	public static void uploadPicture(String picture, String picture1) throws IOException {
		try (FileInputStream in = new FileInputStream(picture);
				FileOutputStream out = new FileOutputStream(picture1);) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);	
			} 
		}
	}
}
