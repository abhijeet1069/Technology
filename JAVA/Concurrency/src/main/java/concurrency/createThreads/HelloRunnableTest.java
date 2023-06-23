package concurrency.createThreads;

public class HelloRunnableTest implements Runnable{
	public void print() {
		System.out.println("Hello,World");
	}
	
	public void run() {
		print();
	}
	
	public static void main(String[] args) {
		Runnable runnable = new HelloRunnable();
		Thread t1 = new Thread(runnable);
		t1.start();
	}
}
