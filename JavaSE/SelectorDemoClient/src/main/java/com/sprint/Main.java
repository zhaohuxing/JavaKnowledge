package com.sprint;

import java.util.*;
import java.io.*;
import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import com.sprint.service.*;
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		ClientService client = ClientService.getInstence();	
		String str = null;
		while(true) {
			str = in.nextLine();
			client.sendMsg(str);
		}
	}

}
