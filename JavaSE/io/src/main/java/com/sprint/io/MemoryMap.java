package com.sprint.io;

import java.io.*;
import java.util.zip.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.channels.*;
public class MemoryMap {
	
	public long checksumInputStream(Path filename) throws IOException {
		try (InputStream in = Files.newInputStream(filename)) {
			CRC32 crc = new CRC32();
			
			int c;
			while ((c = in.read()) != -1)
				crc.update(c);
			return crc.getValue();
		}
	}

	public long checkBufferedInputStream(Path filename) throws IOException {
		try (InputStream in = new BufferedInputStream(Files.newInputStream(filename))) {
			CRC32 crc = new CRC32();
			int c;
			while ((c = in.read()) != -1)
				crc.update(c);
			return crc.getValue();
		}
	}

	public long checksumRandomAccessFile(Path filename) throws IOException {
		try (RandomAccessFile file = new RandomAccessFile(filename.toFile(), "r")) {
			long length = file.length();
			CRC32 crc = new CRC32();

			for (long p = 0; p < length; p++) {
				file.seek(p);
				int c = file.readByte();
				crc.update(c);
			}
			return crc.getValue();
		}
	}

	public long checksumMapperFile(Path filename) throws IOException {
		try (FileChannel channel = FileChannel.open(filename)) {
			CRC32 crc = new CRC32();
			int length = (int)channel.size();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
			for (int p = 0; p < length; p++) {
				int c = buffer.get(p);
				crc.update(c);
			}
			return crc.getValue();
		}
	}
}
