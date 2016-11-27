package com.sprint;

import java.io.IOException;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import com.sprint.thread.UDPThread;

public class Main {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket  = new DatagramSocket(8800);
		DatagramPacket packet = null;

		byte[] data = null;
		int count = 0;
		System.out.println("***服务器启动，等待发送数据***");
		while(true) {
			data = new byte[1024]; //创建字段数组，指定接受的数据包的大小
			packet = new DatagramPacket(data, data.length);
			socket.receive(packet);
			System.out.println(packet.getData());
			new Thread(new UDPThread(socket, packet)).start();	
			count++;
			System.out.println("服务器被连接的次数:" + count);
			InetAddress address = packet.getAddress();
			System.out.println("当前用户客户端的IP为:" + address.getHostAddress());
		}
	}
}
