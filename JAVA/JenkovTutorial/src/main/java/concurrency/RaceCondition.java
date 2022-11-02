package concurrency;
/*
Race conditions is a situation where:
    Two or more threads access the same variables or data in a way where the final result stored in the variable
    depends on how thread access to the variables is scheduled. Such a code section is called critical section.


    Race conditions occur when:
        Two or more threads read and write the same variable(s) or data concurrently.

        The threads access the variables using either of these patterns:
            Check then act

            Read modify write, where the modified value depends on the previously read value.

    The thread access to the variables or data is not atomic.
* */

class Counter{
    private long count = 0;
    public long incAndGet(){
        this.count++; //this.count++ is not a single instruction in VM
        return this.count;
    }
    public long get(){
        return this.count;
    }
}
/*To solve the race conditions, we have to make critical section of code atomic.*/
class CounterSynchronized{
    private long count = 0;
    public long incAndGet(){
        synchronized (this) {
            this.count++; //this.count++ is not a single instruction in VM
            return this.count;
        }
    }
    public long get(){
        synchronized(this) {
            return this.count;
        }
    }
}

public class RaceCondition {
    /*
Long form of below Lambda function.
    class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello, World");
    }
}

public class CreateThreads {
    public static Runnable createThread(){
        MyThread obj = new MyThread();
        return obj;
    }
* */
    private static Runnable getRunnable(Counter counter, String message){
        return ()->{ //run() in being implemented
          for(int i = 0; i < 1_000_000; i++)
              counter.incAndGet();
          System.out.println(message+counter.get());
        };
    }

    private static Runnable getRunnable(CounterSynchronized counter, String message){
        return ()->{ //run() in being implemented
            for(int i = 0; i < 1_000_000; i++)
                counter.incAndGet();
            System.out.println(message+counter.get());
        };
    }

    public static void main(String[] args) {
        /*Each thread should count to a million, but that is not the case.
         If we use 2 counter objects then each thread counts to a million.*/
//        Counter counter = new Counter();
//        Thread thread1 = new Thread(getRunnable(counter,"Thread1 final count: "));
//        thread1.start();
//        Thread thread2 = new Thread(getRunnable(counter,"Thread1 final count: "));
//        thread2.start();

        //Last thread has 2 million count, no matter how many times we execute
        CounterSynchronized counter1 = new CounterSynchronized();
        Thread thread3 = new Thread(getRunnable(counter1,"Thread1 final count: "));
        thread3.start();
        Thread thread4 = new Thread(getRunnable(counter1,"Thread2 final count: "));
        thread4.start();
    }
}
