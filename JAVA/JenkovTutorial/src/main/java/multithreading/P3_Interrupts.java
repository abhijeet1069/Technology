package multithreading;

/*An interrupt is an indication to a thread that it should stop
 * what it is doing and do something else.
 * */

class Interrupt extends Thread{
	public void run() {
		int len = 5;
		try {
			for(int i = 0; i < len; i++) {
				System.out.println("Hello World "+i);
				Thread.sleep(1);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Interrupt occurred");
		}
	}
}

public class P3_Interrupts {
	public static void main(String[] args) throws InterruptedException {
		Interrupt thread = new Interrupt();
		thread.start();
		thread.interrupt();
	}
}
