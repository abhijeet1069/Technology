package concurrency.pauseThreads;

public class SleepMessages {

	public static void main(String[] args) throws InterruptedException {
		String importantInfo[] = {"Mary","had","a","little","lamb"};
		
		for(int i = 0; i < importantInfo.length; i++) {
			Thread.sleep(4000); //Pause for 40ms
			System.out.println(importantInfo[i]);
		}
	}

}
