package com.sprint.file;

import java.io.*;
import java.util.*;
import java.util.regex.*;
public class DirList {
	public static void printDirList(String fileDir, String regex) {
		File path = new File(fileDir);
		String[] list;
		list = path.list(new FilenameFilter() {
						private Pattern pattern = Pattern.compile(regex);
						public boolean accept(File dir, String name) {
							return pattern.matcher(name).matches();
						}});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println("已经执行完毕");
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
