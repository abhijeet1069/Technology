package ch1;

public class SequenceClient {
	public static void main(String[] args) {
		//UnsafeSequence sequence = new UnsafeSequence(); //counts improperly and takes far less time.
		Sequence sequence = new Sequence(); //counts properly till 199 and each thread takes 10ms
				
		Runnable task = ()->{
			int nextValue = sequence.getNext();
			System.out.println(Thread.currentThread().getName()+" : "+nextValue);
		};
		
		Thread[] threads = new Thread[200];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		for(Thread thread : threads) {
			try {
				thread.join();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
