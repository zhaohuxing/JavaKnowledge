package com.sprint.nio.buffer;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.*;
public class NioBufferDemo {
	public static void testByteBuffer(String filename) throws IOException {
		//FileInputStream FileOutputStream RandomAccessFile 同过改造产生FileChannel 
		RandomAccessFile raf = new RandomAccessFile(filename, "rw");

		FileChannel inChannel = raf.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);// allocate() 申请48字节的空间
		int n;
		
		//position list capacity(容量)是ByteBuffer的属性．
		/*写模式:
		 *  position 代表写的当前指针，list,capacity内存容量
		 *
		 *读模式:
		 * position=0 list = 写模式position  capacity内存容量
		 */

		while((n = inChannel.read(buf)) != -1) { //将数据从管道写入到内存,读入一字节，position++;
			
			buf.flip(); //从写模式转换成读模式,此时list置成position的值，position = 0	
			while(buf.hasRemaining()) { //判断是否内存中还要数据
				System.out.print((char)buf.get());
			}
			buf.clear();//读完需要清空内存,以便将其他数据写入到内存, clear()清空全部内存数据，compact()清空读完内存数据
		}
		raf.close();
	}
}
