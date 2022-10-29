package test;

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

public class MultiThread{
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