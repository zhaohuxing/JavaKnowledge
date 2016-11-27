package com.sprint.thread;

import java.io.*;
import java.net.*;
public class ServerThread implements Runnable{
	private Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;

		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			String data = null;
			while ((data=br.readLine()) != null) {
				System.out.println("client msg In Server :" + data);
			}
			socket.shutdownInput();

			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("server respose中文");
			pw.flush();
		} catch (IOException e) {
			System.out.println("IO异常");
		} finally {
			try {
				if (pw != null)
					pw.close();
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (isr != null) 
					isr.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				
				System.out.println("IO关闭异常");
			}	

		}
	}
}
