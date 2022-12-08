package javaIO;

import concurrency.deadlock.Runnable2;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 Pipes in Java IO provides the ability for two threads running the same JVM(same process) to communicate using raw byte data.
 The pipe concept in Java is different from the pipe concept in Unix/Linux, where 2 processes running in different
 address spaces can communicate via a pipe.

 Creating Pipes via Java IO
    Creating a pipe using Java IO is done via the PipedOutputStream and PipedInputStream classes. Both have to be
    connected.The data written to the PipedOutputStream by one thread can be read from the connected PipedInputStream
    by another thread.

    Remember, when using the two connected pipe streams, pass one stream to one thread, and the other stream to another
    thread. The read() and write() calls on the streams are blocking, meaning if you try to use the same thread to both
    read and write, this may result in the thread deadlocking itself.
 * */

public class Pipes { //not a good method
    public static void main(String[] args) throws IOException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);

        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    output.write("Hello World, pipe!".getBytes());
                }catch (Exception e){}
            }
        });

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    int data = input.read();
                    while(data != -1){
                        System.out.print((char)data);
                        data = input.read();
                    }
                }catch(Exception e){}
            }
        });
    }
}
