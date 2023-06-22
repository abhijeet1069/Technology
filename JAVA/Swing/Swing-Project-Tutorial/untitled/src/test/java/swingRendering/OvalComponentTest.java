package swingRendering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OvalComponentTest {
    static boolean isFinished = false;
    public static void print() throws InterruptedException {
        while(!isFinished) {
            System.out.println("Hello,World");
            Thread.sleep(5);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Runnable doPrint = new Runnable() {
            @Override
            public void run() {
                try {
                    print();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(doPrint);
        thread.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.read(); //blocks main thread
        isFinished = true;
        thread.join();
        System.out.println("Stopped at last!!");
    }
}
