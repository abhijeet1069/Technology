package concurrency.volatileTutorial;

/**
	Volatile variables are directly written into memory. Declaring a variable volatile thus guarantees the visibility
	for other threads of writes to that variable.
	
	Also, when JVM encounters volatile it flushes all variables visible to it, to main memory.

 	Accessing volatile variables also prevents instruction reordering which is a normal performance enhancement
 	technique. We should only use volatile variables when you really need to enforce visibility of variables.
 **/

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
