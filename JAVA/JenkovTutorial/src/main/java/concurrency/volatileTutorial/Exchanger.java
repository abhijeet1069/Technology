package concurrency.volatileTutorial;

/*
	Volatile variables are directly written into memory. Declaring a variable volatile thus guarantees the visibility 
	for other threads of writes to that variable.
	
	Also, when JVM encounters volatile it flushes all variables visible to it, to main memory.
	
	To be started from 11:10/21:25 Instruction reordering could break the Java volatile visibility guarantee 
 * */

public class Exchanger {
	private Object object = null;
	private volatile boolean hasNewObject = false;
	
	public void setObject(Object obj) {
		this.object = obj;
		this.hasNewObject = true;
	}
	
	public Object getObject() {
		while(!this.hasNewObject) {
			//busy wait
		}
		Object returnValue = this.object;
		this.hasNewObject = false;
		return returnValue;
	}
}
