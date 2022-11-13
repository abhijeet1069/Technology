package concurrency.falseSharing;

public class FalseSharingExample {
    public static void main(String[] args) {
        Counter1 counter1 = new Counter1(); //Counter2 is x3 times faster
        Counter1 counter2 = counter1; //False sharing takes more time, since both threads are waiting for each other cache to be aligned
       // Counter1 counter2 = new Counter1(); //x4 times faster

        long iterations = 1_000_000_000;
        Thread thread1 = new Thread(()->{
            long startTime = System.currentTimeMillis();
            for(long i=0; i < iterations; i++)
                counter1.count1++;
            long endTime = System.currentTimeMillis();
            System.out.println("Total time: "+(endTime-startTime));
        });

        Thread thread2 = new Thread(()->{
            long startTime = System.currentTimeMillis();
            for(long i=0; i < iterations; i++)
                counter2.count2++;
            long endTime = System.currentTimeMillis();
            System.out.println("Total time: "+(endTime-startTime));
        });
        thread1.start();
        thread2.start();
    }
}
