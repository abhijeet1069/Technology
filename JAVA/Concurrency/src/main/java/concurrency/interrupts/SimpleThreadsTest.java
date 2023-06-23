package concurrency.interrupts;

import concurrency.util.AppConstants;

/*
An interrupt is an indication to a thread that it should stop what it is doing and do something else.
Mainly an exception in class
 * */

class MessageLoop implements Runnable, AppConstants {
	@Override
	public void run() { //takes importantInfo.length*1000 ms
		String importantInfo[] = {"Mary","had","a","little","lamb"};
		try {
			for(int i = 0; i < importantInfo.length; i++) {
				Thread.sleep(1000);
				threadMessage(importantInfo[i],ANSI_RED);
			}
		}catch(InterruptedException e) {
			threadMessage("I wasn't done",ANSI_RED);
		}
	}
	
	static void threadMessage(String message, String color) {
		String threadName = Thread.currentThread().getName();
		System.out.format(color+"%s: %s%n", threadName,message);
	}
}

public class SimpleThreadsTest implements AppConstants{
	public static void main(String[] args) throws InterruptedException{
		long patience = 3000;
		MessageLoop.threadMessage("Starting MessageLoop thread",ANSI_GREEN);
		Thread t = new Thread(new MessageLoop());
		t.start();
		
		MessageLoop.threadMessage("Waiting for MessageLoop thread to finish",ANSI_GREEN);
		while(t.isAlive()) {
			t.join(patience); //main thread (calling thread) has to wait for 8000 ms
			MessageLoop.threadMessage("Tired of waiting...",ANSI_GREEN);
			t.interrupt();
			t.join(); //wait till t has finished before going to next while loop iteration
			}
		MessageLoop.threadMessage("I am back...",ANSI_GREEN);
	}
}