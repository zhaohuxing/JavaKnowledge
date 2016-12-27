package com.sprint.service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.channels.NoConnectionPendingException;
public class ClientService {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 19999;
	
	private static SocketChannel channel;
	private static Object lock = new Object();


	private static ClientService INSTENCE;
	public static ClientService getInstence() throws IOException {
		synchronized(lock) {
			if (INSTENCE == null) {
				INSTENCE = new ClientService();
			}
			return INSTENCE;
		}
	}

	private ClientService() throws IOException {
		channel = SocketChannel.open(); //open channel
		channel.configureBlocking(false);//selector 要求非阻塞
		channel.connect(new InetSocketAddress(HOST, PORT)); //创建连接服务器，前提服务器开着，否则报异常
	}

	public void sendMsg(String msg) {
		try {
			while(!channel.finishConnect()) {
				//完成socket channel 的连接	
			}
			channel.write(ByteBuffer.wrap(msg.getBytes()));
		} catch (IOException e) {
			throw new NoConnectionPendingException();
		}
	}

	public String receiveMsg() {
		ByteBuffer buffer = ByteBuffer.allocate(1024); //申请1024字节的内存	
		buffer.clear(); //将内存中的数据全部清空
		StringBuffer strBuffer = new StringBuffer();
		int count = 0;
		String msg = null;
		try {
			Thread.sleep(100);
			while((count = channel.read(buffer)) != -1) {
				strBuffer.append(new String(buffer.array(), 0, count));
			}
			if (strBuffer.length() > 0) {
				msg = strBuffer.toString();
				if ("close".equals(msg)) {
					msg = null;
					channel.close();
					channel.socket().close();
				}
			}
		} catch (InterruptedException e) {
		//	throw new InterruptedException();	
		} catch (IOException e) {
		//	throw new IOException();
		}

		return msg;
	}
}
