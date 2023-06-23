package concurrency.synchronization;

/*
Threads communicate primarily by sharing access to fields and the objects reference fields refer to. This form of
communication is efficient but makes two kinds of errors possible:
	a) Thread Interference
	b) Memory inconsistency errors

These errors are prevented using synchronization.
 * */

public class ThreadInterference {
	 private static int counter = 0; //t1, t2 will interfere with counter 

	    public static void main(String[] args) throws InterruptedException {
	        Thread t1 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                for (int i = 0; i < 10000; i++) {
	                    counter++; //not an atomic action
	                }
	            }
	        });

	        Thread t2 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                for (int i = 0; i < 10000; i++) {
	                    counter++;
	                }
	            }
	        });

	        t1.start();
	        t2.start();

	        t1.join();
	        t2.join();

	        System.out.println("Counter value: " + counter);
	    }
}
