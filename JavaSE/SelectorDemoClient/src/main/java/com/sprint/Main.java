package com.sprint;

import java.util.*;
import java.io.*;
import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
public class Main {
	public static void main(String[] args) throws IOException{
		SocketChannel channel = SocketChannel.open(); // create socket channel
		channel.configureBlocking(false); //set channel non-blocking
		InetSocketAddress s = new InetSocketAddress("127.0.0.1", 3000);// instantiate SocketAddress
		channel.connect(s); //connect channel's socket
		
		SocketChannel channel1 = SocketChannel.open();
		channel1.configureBlocking(false);
		InetSocketAddress s1 = new InetSocketAddress("127.0.0.1", 3001);
		channel1.connect(s1);

		Selector selector = Selector.open(); // open a selector
		SelectionKey key = channel.register(selector, SelectionKey.OP_CONNECT|SelectionKey.OP_WRITE); // 将channel注册到selector,并返回SelectionKey
		SelectionKey key1 = channel1.register(selector, SelectionKey.OP_CONNECT|SelectionKey.OP_WRITE);
		
		Charset charset = Charset.forName("UTF-8");
	
		channel.finishConnect();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		ByteBuffer info = charset.encode("人生百态");
		buf.put(info);
		buf.flip();
		channel.write(buf);
		buf.clear();
		/*
		boolean isFinished = false;
		while(!isFinished) {
			int num = selector.select();
			System.out.println("first print num:" + num);
			if (num > 0) {
				Set<SelectionKey> keys = selector.selectedKeys();
				for (SelectionKey k : keys) {
					System.out.println("first print num in:" + keys.size());
					if (k.isConnectable()) {
						SocketChannel sc = (SocketChannel)k.channel();
						sc.configureBlocking(false);
						sc.finishConnect();
						sc.register(selector, SelectionKey.OP_WRITE);

						ByteBuffer buf = ByteBuffer.allocate(1024);
						ByteBuffer info = charset.encode("人生百态，要学会臭不要脸");
						buf.put(info);
						buf.flip();
						sc.write(buf);
						buf.clear();
						System.out.println("first print num:写入完毕" + num);
					} else if(k.isValid() && k.isReadable()){
						ByteBuffer buf = ByteBuffer.allocate(1024);
						SocketChannel sc = (SocketChannel)k.channel();
						sc.read(buf);
						buf.flip();
						System.out.println("echo server return:" + charset.decode(buf).toString());
						buf.clear();
						isFinished = true;
					//	k.cancel();
					//	sc.close();
					//	selector.close();
					}	
				}
			}
		}	*/
	}
}
