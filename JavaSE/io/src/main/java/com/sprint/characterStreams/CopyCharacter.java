package com.sprint.characterStreams;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyCharacter {
	public void copyCharacter(String filenameA, String filenameB)  throws IOException{
		/*try -resource - catch 是JDK7有的，方便处理异常流的关闭*/
		try (FileReader inputStream = new FileReader(filenameA);
			 FileWriter outputStream = new FileWriter(filenameB)) {
			
			int c;
			while((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
		 }	
	}
}
