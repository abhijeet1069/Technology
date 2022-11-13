package monitor;
import java.io.*;
/*

 In JAVA monitor is implemented via synchronized keyword.
 
 A monitor is a synchronization mechanism designed in early 1970.
 
 It provides following capabilities to concurrent programs:
 	1. Only 1 thread at a time has mutually exclusive access to a critical section.
 	2. Threads running in a monitor can block awaiting certain conditions to become true.
 	3. A thread can notify one or more threads that conditions they are waiting on have been met.
 
 
 All objects in JAVA can be used as built in monitor objects, which support 2 types of thread synchronization.
 	
 	1) Mutual Exclusion
 		Allows concurrent access and updates to shared data without race conditions.
 		Mutual exclusion is supported via an Entrance Queue and synchronized methods.
 	
 	2) Coordination
 		Ensures computations run properly, in right order and right time under right conditions
 		Coordination is supported via Wait Queue and notification mechanisms.
 * */

class SharedDataPrinter {

	// Monitor implementation is carried on by
	// Using synchronous method
	// Method (synchronized)
	synchronized public void display(String str)
	{

		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));

			// Try-catch bloc for exceptions as we are
			// using sleep() method
			try {

				// Making thread to sleep for very
				// nanoseconds as passed in the arguments
				Thread.sleep(100);
			}
			catch (Exception e) {
			}
		}
	}
}

//Class 2
//Helper class extending the Thread class
class Thread1 extends Thread {

	SharedDataPrinter p;

	// Thread
	public Thread1(SharedDataPrinter p)
	{

		// This keyword refers to current instance itself
		this.p = p;
	}

	// run() method for this thread invoked as
	// start() method is called in the main() method
	public void run()
	{

		// Print statement
		p.display("Geeks");
	}
}

//Class 2 (similar to class 1)
//Helper class extending the Thread class
class Thread2 extends Thread {

	SharedDataPrinter p;

	public Thread2(SharedDataPrinter p) { this.p = p; }

	public void run()
	{

		// Print statement
		p.display(" for Geeks");
	}
}

//Class 3
//Main class
public class UnderstandMonitor {

	// Main driver method
	public static void main(String[] args)
	{

		// Instance of a shared resource used to print
		// strings (single character at a time)
		SharedDataPrinter printer = new SharedDataPrinter();

		// Thread objects sharing data printer
		Thread1 t1 = new Thread1(printer);
		Thread2 t2 = new Thread2(printer);

		// Calling start methods for both threads
		// using the start() method
		t1.start();
		t2.start();
	}
}
