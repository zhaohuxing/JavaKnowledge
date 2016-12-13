package com.sprint.file;

import java.io.*;
public class MakeDirectories {
	private static void usage() {
		System.out.println(
				"Usage:MakeDirectories path1 ...\n" + 
				"Create each path\n" + 
				"Usage:MakeDirectories -d path1 ...\n" +
				"Deletes each path\n" + 
				"Usage:MakeDirectories -r path1 path2\n" +
				"Renames from to path2");
		System.exit(1);
	}
	
	private static void fileData(File f) {
		System.out.println(
				"Absolute path:" + f.getAbsolutePath() + 
				"\n Can read:" + f.canRead() +
				"\n Can write:" + f.canWrite() + 
				"\n getName:" + f.getName() + 
				"\n getParent:" + f.getParent() + 
				"\n getPath:" + f.getPath() + 
				"\n length:" + f.length() + 
				"\n lastModified:" + f.lastModified());
		if (f.isFile()) 
			System.out.println("It`s a file");
		else if (f.isDirectory())
			System.out.println("It`s a directory");
	} 
}
