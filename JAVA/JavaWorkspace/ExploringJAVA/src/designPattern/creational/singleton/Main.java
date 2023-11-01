package designPattern.creational.singleton;

public class Main {
	public static void main(String[] args) {
		
		int threadCount = 100;
		
		Thread[] threads = new Thread[threadCount];
		
		for(int i = 0; i < threadCount; i++) {
			threads[i] = new Thread(()->{
				
				//actual invocation
				SingleTon singleton = null;
				singleton = SingleTon.getInstance();
				//singleton = new SingleTon();
				System.out.println(" Object of "+singleton.getClass().getName()+" with ID : "+System.identityHashCode(singleton));
			
			});
			threads[i].start();
		}
		
		for(Thread thread : threads) {
			try {
				thread.join(); //ask main to wait till all threads have stopped completing
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
