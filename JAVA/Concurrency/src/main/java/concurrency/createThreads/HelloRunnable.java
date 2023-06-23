package concurrency.createThreads;

public class HelloRunnable implements Runnable{
	
	public void run() {
		System.out.println("Hello,World");
	}
	
	public static void main(String[] args) {
		Runnable runnable = new HelloRunnable();
		Thread t1 = new Thread(runnable);
		t1.start();
	}
}
