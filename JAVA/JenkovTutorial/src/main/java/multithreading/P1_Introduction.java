package multithreading;

/*In concurrent programming, there are two basic units of execution: processes and threads. 
 * In the Java programming language, concurrent programming is mostly concerned with threads.
 * 
 * Threads exist within a process — every process has at least one. 
 * Threads share the process's resources, including memory and open files. 
 * This makes for efficient, but potentially problematic, communication.
 * 
 * Creating Threads:
 * 	1) Extending Thread class
 *  2) Implementing Runnable interface 
 * */



class HelloThread extends Thread{ 
	public void run() {
		System.out.println("Hello from thread!!");
	}
}

public class P1_Introduction implements Runnable{
	public void run() {
		System.out.println("Hello, World!!");
	}
	public static void main(String[] args) {
		(new Thread(new P1_Introduction())).start();
		(new HelloThread()).start();
	}

}
