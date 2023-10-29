package designPattern.singleTon;

class Hello{
	
	String threadName = Thread.currentThread().getName();
	
	Hello(){
		System.out.println(this.getClass().getName()+" object created" );
	}
	
	public void printMessage() {
		//System.out.println(+": Hello,World");
	}
}

public class Main {
	public static void main(String[] args) {
		
		int threadCount = 5;
		
		Thread[] threads = new Thread[threadCount];
		
		for(int i = 0; i < threadCount; i++) {
			threads[i] = new Thread(()->{
				
				//actual invocation
				Hello hello = new Hello();
				hello.printMessage();
			
			
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
