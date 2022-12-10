package javaIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 Buffered stream is actually a wrapper for normal stream. For faster execution, read data in chunks rather than in bytes.
 Also, buffered stream is x2 faster than normal stream.
 * */

public class TestStream {

    public static void printFile() throws IOException {
        //BufferedInputStream = Read time 0.008 sec
        //FileInputStream = Read time 0.017 sec
        InputStream input = new BufferedInputStream(new FileInputStream("input.txt"));
        int data = input.read();
        while(data != -1){
            System.out.print((char)data);
            data = input.read();
        }
    }

    public static void main(String[] args) throws IOException {
        final long startTime = System.currentTimeMillis();
        printFile();
        final long endTime = System.currentTimeMillis();
        System.out.println("\nTotal execution time(sec): "+(endTime-startTime)/1000.0);
    }
}
