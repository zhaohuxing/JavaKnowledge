package com.sprint.thread;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDPThread implements Runnable {
	DatagramSocket socket = null;
	DatagramPacket receivePacket = null;

	public UDPThread(DatagramSocket socket, DatagramPacket receivePacket) {
		this.socket = socket;
		this.receivePacket = receivePacket;
	}

	@Override
	public void run() {
		String info = null;
		InetAddress address = null;
		int port = 8800;
		byte[] data = null;
		DatagramPacket packet = null;

		try {
			System.out.println("问题出现在这？");
			info = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println(info);
			System.out.println("我是服务器，客户端说:" + info);

			address = receivePacket.getAddress();
			port = receivePacket.getPort();
			data = "我在响应你".getBytes();
			packet = new DatagramPacket(data, data.length, address, port);
			socket.send(packet);
		} catch (IOException e) {
			System.out.println("线程发生问题");
		}
	}
}
