package com.sprint.service;

import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.ServerSocketChannel;
import java.net.InetSocketAddress;
public class ServerService implements Runnable {
	private Selector selector;
	private SelectionKey selectionKey;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public ServerService(int port) throws IOException {
		init(port);
	}

	private void init(int port) throws IOException {
		selector = Selector.open();
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.socket().bind(new InetSocketAddress(port));
		serverChannel.configureBlocking(false);
		selectionKey = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("服务器启动...");
	}

	@Override
	public void run() {
		try {
			while(true) {
				int n = selector.select(); 
				if (n > 0) {
					Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
					while (iter.hasNext()) {
						SelectionKey key = iter.next();
						if (key.isAcceptable()) {
							iter.remove();
							ServerSocketChannel serverChannel = (ServerSocketChannel)key.channel();
							SocketChannel channel = serverChannel.accept();
							if (channel == null) {
								continue;
							}
							channel.configureBlocking(false);
							channel.register(selector, SelectionKey.OP_READ);
						}
						
						if (key.isReadable()) {
							readMsg(key);
						}

						if (key.isWritable()) {
							writeMsg(key);
						}
					}
				}
			}
		} catch (IOException e) {
				
		}
	}

	public void readMsg(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel)key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		StringBuffer strBuffer = new StringBuffer();
		int count = 0;
		while ((count = channel.read(buffer))!= -1) {
				buffer.flip();
				strBuffer.append(new String(buffer.array(), 0, count));
		}
		String str = strBuffer.toString();
		System.out.println(str);
	}
	public void writeMsg(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel)key.channel();
	}
}
