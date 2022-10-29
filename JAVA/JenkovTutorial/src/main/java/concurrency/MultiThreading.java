package concurrency;


/*
	Java concurrency is a term that covers multi-threading, concurrency and parallelism on Java platform. 
	
	A multi-threaded application is like an application that has multiple CPUs executing different parts of the code at the same time.
 * */

class MyThread extends Thread{
	public void run(){
		try {
			//System.out.println(Thread.currentThread().getName()+" : Going to Sleep..");
			sleep(3000);
			System.out.println(Thread.currentThread().getName()+" : Awake");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

public class MultiThreading{
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		MyThread thread0 = new MyThread();
		thread0.start();
		MyThread thread1 = new MyThread();
		thread1.start();
		
		long endTime = System.nanoTime();
		System.out.println("Program took (ms) : "+(endTime-startTime)/1000000);
	}

}
