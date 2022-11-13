package concurrency.multithreading;


/*
	Java concurrency is a term that covers multi-threading, concurrency and parallelism on Java platform.

	A Multithreaded application is like an application that has multiple CPUs executing different parts of
	the code at the same time.
 * */

class MyRunnable implements Runnable {
	private boolean doStop = false;
	public synchronized void doStop() {
		this.doStop = true;
	}
	private synchronized boolean keepRunning() {
		return this.doStop == false;
	}
	@Override
	public void run() {
		while(keepRunning()) {
			// keep doing what this thread should do.
			System.out.println("Running");

			try {
				Thread.sleep(3L * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

public class StopThread {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		try {
			Thread.sleep(10L * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myRunnable.doStop();
	}
}
