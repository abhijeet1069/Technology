package concurrency.interrupts;

import concurrency.util.AppConstants;

/*
An interrupt is an indication to a thread that it should stop what it is doing and do something else.
Mainly an exception in class
 * */

public class SimpleThreads implements AppConstants{
	static void threadMessage(String message, String color) {
		String threadName = Thread.currentThread().getName();
		System.out.format(color+"%s: %s%n", threadName,message);
	}
	
	public static class MessageLoop implements Runnable{
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
	}
	
	public static void main(String[] args) throws InterruptedException{
		long patience = 1000;
		threadMessage("Starting MessageLoop thread",ANSI_GREEN);
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		
		threadMessage("Waiting for MessageLoop thread to finish",ANSI_GREEN);
		while(t.isAlive()) {
			t.join(8000); //main thread (calling thread) has to wait for 2000 ms
			threadMessage("Tired of waiting...",ANSI_GREEN);
			
			if(((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
				threadMessage("Tired of waiting!!",ANSI_GREEN);
				t.interrupt();
				t.join();
			}
		}
		threadMessage("Finally...",ANSI_GREEN);
	}
}