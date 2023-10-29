package memoryUsage;

// 36 MB
// 100000000000 * 4 * 100 bytes
// Theoretical calculation = 40,000,000 MB
// Actual memory consumption = 36 MB. So a lot is happening under the hood.
// Visual VM is a good analysis tool.

class Hello{
	int[] arr;
	
	Hello(){
		this.arr = new int[100]; //10* 4bytes = 40 bytes
	}
}

class TimeConsumingOperation {
    public void task() {
        // Simulate a time-consuming operation
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < 100000000000l; i++) {
            Hello hello = new Hello();
        }
        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        System.out.println("Time-consuming operation took " + elapsedTime/1000.0 + " seconds.");
    }
}

public class SampleProgram {

	public static void main(String[] args) throws InterruptedException {
		
		//Thread.sleep(100000);
		TimeConsumingOperation program = new TimeConsumingOperation();
		program.task();
	}

}
