package files.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
NIO - New File Input Output. Introduced in Java 1.4
NIO has two fundamental items:
	a) buffers - holds data 
	b) channels - represents an open connection to I/O device, such as file or a socket
 * */

public class NIOTest {
	private static final int BSIZE  = 1024;
	
	public static void main(String[] args) throws IOException {
		FileChannel filech1 = new FileOutputStream("/Users/satyam/Personal/Technology/JAVA/BlackBook/AdvanceJava/res/file6.txt").getChannel();
		filech1.write(ByteBuffer.wrap("Some text ".getBytes()));
		filech1.close();
		
		filech1 = new RandomAccessFile("/Users/satyam/Personal/Technology/JAVA/BlackBook/AdvanceJava/res/file6.txt","rw").getChannel();
		filech1.position(filech1.size());
		filech1.write(ByteBuffer.wrap("Some more text".getBytes()));
		filech1.close();
		
		filech1 = new FileInputStream("/Users/satyam/Personal/Technology/JAVA/BlackBook/AdvanceJava/res/file6.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		filech1.read(buff);
		buff.flip();
		while(buff.hasRemaining())
			System.out.print((char)buff.get());
		
	}
}
