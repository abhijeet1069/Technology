package concurrency.volatileTutorial;

public class MainDriver {
    public static void main(String[] args) {
        VolatileCounter ctr = new VolatileCounter();
        Thread thread = new Thread(()->{
            long startTime = System.currentTimeMillis();
            for(int i = 0; i < 1_000_000_000; i++)
                ctr.increment();
            System.out.println("Counter = "+ctr.getCounter());
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken:(sec) "+(endTime-startTime)/1000.0); //milli-sec to sec
        });
        thread.start();
    }
}
