package com.sprint;

import java.io.IOException;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class Main {
	public static void main(String[] args) throws IOException{
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "用户名:adimin, 密码: 123456".getBytes();
		
		//DatagramPacket 数据包 DatagramSocket 发送数据包
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);

		byte[] responseData = new byte[1024];
		DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
		socket.receive(responsePacket);
		String info = new String(responseData, 0, responsePacket.getLength());
		System.out.println("我是客户端,服务器说:" + info);
		socket.close();
	}
}
