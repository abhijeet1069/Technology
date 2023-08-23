package ch1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/*
 * If multiple threads access the same mutable state variable without appropriate synchronization, your program is broken. There are three ways to fix it:
 * 		Don't share the state variable across threads;
 * 		Make the state variable immutable; or
 * 		Use synchronization whenever accessing the state variable.
 * 
 * A class is thread-safe if it behaves correctly when accessed from multiple threads, regardless of the scheduling or interleaving of the execution of those
 * threads by the runtime environment, and with no additional synchronization or other coordination on the part of the calling code.
 * 
 * Stateless objects are always thread-safe.
 * */



@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext() {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return nextValue++;
    }
}
