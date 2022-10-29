package multithreading;

/*If t is a Thread object whose thread is currently executing, 
 * then t.join() will make sure that t is terminated before the
 *  next instruction is executed by the program.
 *  
 *  In below example main thread will go to waiting state
 * */

class ThreadJoining extends Thread{
	public void run() {
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(800);
				System.out.println("Hi "+Thread.currentThread().getName());
			}
			catch(Exception ex) {
				System.out.println("Exception in"+Thread.currentThread().getName());
				ex.printStackTrace();
			}
			System.out.println(i);
		}
	}
}

public class P4_ThreadJoining {
	public static void main(String[] args) {
		ThreadJoining t0 = new ThreadJoining();
		ThreadJoining t1 = new ThreadJoining();
		ThreadJoining t2 = new ThreadJoining();
		// thread t1 starts 
        t0.start(); 
        // starts second thread after when 
        // first thread t1 has died. 
        try { 
            System.out.println("Current Thread: "
                  + Thread.currentThread().getName()); 
            t0.join(); 
        } 
  
        catch(Exception ex) { 
            System.out.println("Exception has " + 
                                "been caught" + ex); 
        } 
  
        // t2 starts 
        t1.start(); 
  
        // starts t3 after when thread t2 has died. 
        try { 
            System.out.println("Current Thread: "
                 + Thread.currentThread().getName()); 
            t1.join(); 
        } 
  
        catch(Exception ex) { 
            System.out.println("Exception has been" + 
                                    " caught" + ex); 
        } 
  
        t2.start(); 
	}
}
