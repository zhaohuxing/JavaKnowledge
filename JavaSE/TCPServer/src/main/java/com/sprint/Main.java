package com.sprint;

import com.sprint.thread.*;
import java.io.*;
import java.net.*;
public class Main {
	public static void main(String[] args) {
		 try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = null;
            int count = 0;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            while(true){ 
                socket = serverSocket.accept();
                Thread thread = new Thread(new ServerThread(socket));
                thread.start();

                count++;
                System.out.println("服务器端被连接过的次数："+count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP为："+address.getHostAddress());
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }		
}
