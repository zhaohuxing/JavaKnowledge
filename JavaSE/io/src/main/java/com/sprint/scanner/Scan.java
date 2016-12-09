package com.sprint.scanner;

import java.util.*;
import java.io.*;
public class Scan {
	public static void printMsg(String filenameA) throws IOException {
		try (Scanner in = new Scanner(new BufferedReader(new FileReader(filenameA)));) {
			//Scanner 默认使用空格作为分割
			//in.useDelimiter("\\n"); //使用 回车来分割字符
			String result = in.delimiter().pattern();
			System.out.println(result);
			double sum = 0;
			while (in.hasNext()) {
				if (in.hasNextDouble()) {
					double value = in.nextDouble();
					sum += value;
					System.out.println(value);
				} else {
					in.next();
				}
			}

			System.out.println(sum);
		}
	}		
}
