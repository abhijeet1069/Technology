package syncBlocks;

/*
	When a thread enters into synchronized instance method or block, it acquires Object level lock,
	and when it enters into synchronized static method or block it acquires class level lock.
	
	Limitations of Java synchronized blocks:
		1) Only 1 thread can enter a synchronized block at a time.
		2) There is no guarantee about the sequence in chich waiting threads gets access to the synchronized block.
 * */


public class SynchronizedExchanger {
	protected Object object=null; //Monitor Object - Since, read and write operations are synchronized. object itself
								  //acts as monitor object
	
	public synchronized void setObject(Object o) {
		this.object = o;
	}
	
	public synchronized Object getObject() { //only 1 thread executes this method for a given object
		return this.object;
	}
	
	public void setObj(Object o) { 
		synchronized(this) {//Synchronized Block : Alternative for synchronized function:Make its content synchronized
			this.object = o;
		}
	}
	
	public Object getObj() {
		synchronized(this) {
			return this.object;
		}
	}
}
