package concurrency;
/*
    There is a field value of Counter class, which is incremented. But to access the value it takes 3 seconds.
    2 threads read the current value and increment it.
    Case 1 : Time taken for non-atomic case
    Case 2 : Time taken for atomic case
* */
class Counter1{
    int count;
    public int increment() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(2000);
            this.count++;
            return count;
        }
    }
    public void printVal(){
        System.out.println("Counter1.count = "+this.count);
    }
}

public class TestSynchronized {
    public static Runnable getRunnable(Counter1 counter, String name){
        return ()->{
            System.out.println("Thread name = "+name);
            try {
                counter.increment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter.printVal();
        };
    }

    public static void main(String[] args) {
        Counter1 counter = new Counter1();
        Thread t1 = new Thread(getRunnable(counter,"Thread 1"));
        Thread t2 = new Thread(getRunnable(counter, "Thread 2"));
        t1.start();
        t2.start();
    }
}
