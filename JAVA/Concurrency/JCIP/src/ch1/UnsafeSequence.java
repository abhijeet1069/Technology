package ch1;

import net.jcip.annotations.NotThreadSafe;

/**
 * UnsafeSequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return value++;
    }
}
