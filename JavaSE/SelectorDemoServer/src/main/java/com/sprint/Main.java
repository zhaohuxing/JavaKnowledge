package com.sprint;

import java.nio.ByteBuffer;
import java.io.IOException;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
public class Main {
	private Charset charset = Charset.forName("UTF-8");
	private int[] ports;
	public static void main(String[] args) {
		int[] portss = {3000, 3001};
		new Main(portss);	
	}

	public Main(int[] ports) {
		this.ports = ports;
		try {
			go();
		} catch(IOException e) {
			//怎么处理异常？	
		}
	}

	public void go() throws IOException {
		Selector selector = Selector.open();
		
		for (int i = 0; i < ports.length; i++) {
			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.configureBlocking(false);
			ServerSocket socket = channel.socket();
			InetSocketAddress address = new InetSocketAddress("127.0.0.1", ports[i]);
			socket.bind(address);

			channel.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("Going to listen :" + ports[i]);
		}

		while (true) {
			int num = selector.select();
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iter = keys.iterator();
			while (iter.hasNext()) {
				SelectionKey key = iter.next();

				if ((key.readyOps()&SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
					ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					iter.remove();
				} else if ((key.readyOps()&SelectionKey.OP_READ) == SelectionKey.OP_READ) {
					SocketChannel sc = (SocketChannel)key.channel();
					if (!sc.isOpen()) {
						selector = Selector.open();
					} else {
						ByteBuffer buf = ByteBuffer.allocate(1024);
						while(sc.read(buf) > 0) {
							System.out.println("Echo" + charset.decode(buf).toString() + "from" + sc.socket().getInetAddress().getHostAddress());
							buf.flip();
							sc.write(buf);
							buf.clear();
						}
						iter.remove();
						key.cancel();
						sc.close();
					}
				}
			}
		}
	}
}
