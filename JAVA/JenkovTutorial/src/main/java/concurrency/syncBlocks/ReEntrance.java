package concurrency.syncBlocks;

/*
 A thread that already holds the lock on the concurrency.monitor object at given synchronized block
 is allowed to enter synchronized block of same concurrency.monitor object.
For ex : Although inc() is synchronized it will not block incAndGet
*/
public class ReEntrance {
	private int count = 0;
	
	public synchronized void inc() {
		this.count++;
	}
	
	public synchronized int incAndGet() {
		inc(); 
		return this.count;
	}
}
