package multithreading;

/*Thread.sleep(time in ms) - Causes current thread to suspend
 * execution for a specified amount of time.
 * */

public class P2_Sleep {
	public static void main(String[] args) throws InterruptedException {
		String[] importantInfo = {"Mary","had","a","little","lamb"};
		for(int i = 0; i < importantInfo.length; i++) {
			Thread.sleep(1000);
			System.out.println(importantInfo[i]);
		}
	}
}
