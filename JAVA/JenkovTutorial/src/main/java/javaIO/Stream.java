package javaIO;

/**
 Java IO is an API that comes with Java which is targeted at reading and writing data (input and output). Its purposes are:
    File access
    Network access
    Internal Memory buffer access
    Inter Thread Communication (pipes)
    Buffering
    Filtering
    Parsing
    Reading and Writing Text
    Reading and Writing Primitive data(long, int etc.)
    Reading and Writing Objects

 Byte based - contains 'stream'
 Character based - contains 'reader/writer'

 Java's IO package is mostly concerned with reading of raw data from a source and writing of raw data to a destination.
 The most typical sources and destinations of data are:
    Files
    Pipes
    Network Connections
    In-memory buffers (eg, arrays)
    System.in, System.out, System.error

 Streams:
    IO stream is a continuous flow of data. Streams in Java IO can either be byte based or character based.
    Stream has no concept of an index of the read or written data, like an array does.

 Combining streams:
    You can combine streams into chains to achieve more advanced input and output operations. For instance, reading
    every byte one at a time from a file is slow. It is faster to read a larger block of data from the disk and then
    iterate through that block byte for byte afterwards. To achieve buffering you can wrap your InputStream in an
    BufferredInputStream.
        InputStream input = new BufferedInputStream(new FileInputStream("input.txt"));
    Buffering can also be applied to OutputStream for faster output.
    Buffering is just one way of combining streams. You can also wrap your InputStream in a PushBackStream. This comes
    handy during parsing.
 * */

import java.io.*;

public class Stream {
    public static void main(String[] args) throws IOException {
        //input stream
        InputStream input = new FileInputStream("input.txt");
        int data = input.read();
        while(data != -1){
            System.out.print((char)data);
            data = input.read();
        }

        //output stream
        OutputStream output = new FileOutputStream("output.txt");
        output.write("Hello, World".getBytes());
        input.close();
        output.close();
    }
}
