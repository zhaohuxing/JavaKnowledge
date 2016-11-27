package com.sprint;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) {
		try {

			Socket socket = new Socket("localhost", 8080);
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("username:xxx, password:123456");
			pw.flush();
			socket.shutdownOutput();

			InputStream is = socket.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String data = null;
			while ((data=br.readLine()) != null) {
				System.out.println("server msg In Client:" + data);
			}

			System.out.println("s未发现主机");
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("未发现主机");
		} catch (IOException e) {
			System.out.println("IO输入异常");
		}
	}
}
