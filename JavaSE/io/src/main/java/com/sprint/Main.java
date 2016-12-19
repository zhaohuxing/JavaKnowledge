package com.sprint;

import com.sprint.nio.*;
import com.sprint.domain.*;
import com.sprint.byteStreams.*;
import com.sprint.characterStreams.*;
import com.sprint.bufferedStreams.*;
import com.sprint.scanner.*;
import com.sprint.test.*;
import com.sprint.dataStreams.*;
import com.sprint.file.*;
import com.sprint.objectStream.*;
import java.io.*;
import java.util.*;
import com.sprint.io.*;
import java.nio.file.*;


public class Main {
	public static void main(String[] args) throws Exception {
		
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("邢照虎", 3000, 1995, 12, 11);
		staff[1] = new Employee("庞杰", 8000, 1995, 12, 11);
		staff[2] = new Employee("云来", 10000, 1995, 12, 11);
		

	//	try (PrintWriter out = new PrintWriter("emplyeex.dat", "UTF-8")) {
	//		for(Employee employee : employees) {
	//			out.println(employee);
	//		}
	//	}

	//	try (Scanner in = new Scanner(new FileInputStream("emplyeex.dat"), "UTF-8")) {
	//		for (int i = 0; i < 3; i++) {
	//			System.out.println(in.nextLine());
	//		}
	//	}
		EmployeeIO employeeIO = new EmployeeIO();
		try (PrintWriter out = new PrintWriter("staff.txt", "UTF-8")) {
			employeeIO.writeData(staff, out);
		}

		try(Scanner in = new Scanner(new FileInputStream("staff.txt"), "UTF-8")) {
			Employee[] newStaff = employeeIO.readData(in);
			for (Employee employee : newStaff) {
				System.out.println(employee);
			}
		}
	//	Scanner in = new Scanner(new FileInputStream("employee.txt"), "UTF-8");
	//	while (in.hasNext()) {
	//		//System.out.println(in.next());	in.next()是以空格，回车为分割的
	//		System.out.println(in.nextLine());	//in.nextLine();以回车分割的
	//	}
		MemoryMap mm = new MemoryMap();
		System.out.println("Input Steam:");
		long start = System.currentTimeMillis();
		Path filename = Paths.get("/home/sprint/java/code/JavaKnowledge/JavaSE/io/employee.txt");
		long crcValue = mm.checksumInputStream(filename);
		long end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + "milliseconds");
		
		CopyBytes cBytes = new CopyBytes();
		cBytes.copyBytes("employee.txt", "bytes.txt");

		CopyCharacter cc = new CopyCharacter();
		cc.copyCharacter("employee.txt", "character.txt");
		
		CopyLines.copyLines("employee.txt", "lines.txt");
		
		CopyBuffered.copyBuffered("employee.txt", "buffered.txt");
		
		Scan.printMsg("employee.txt");
		
		Password.inputPassword();
		
		Picture.uploadPicture("signupError.jpg", "xxx.jpg");
		
//		DataStreamsDemo.writeData("dataStreams.txt");
//		DataStreamsDemo.readData("dataStreams.txt");
		DirList.printDirList("/home/sprint/js/code/c", ".*\\.java");	
		System.out.println("Directory.测试");
		System.out.println(Directory.walk("."));
		new ProcessFiles(new ProcessFiles.Strategy() {
			public void process(File file) {
				System.out.println(file);
			}
		}, "java").start();
		

		ObjectStreamMain.testObjectStream();
		ExternalDemo.testExternal();
		TransientDemo.testTransient();
		MappedIO.print();
		System.out.println(BufferedInputFile.read("employee.txt"));
		StringReaderFile.read("employee.txt");
		DataInputStreamFile.read("lines.txt");
		BasicFileOutput.printf("employee.txt", "basicPrint.txt");
		StoringAndRecoveringData.printf("storeAndRecover.txt");

	}


}
