package concurrency.threadSignaling;

/**
 To solve multiple notify case, we use a counter variable.
 Best example to understand wait issues in thread


 * **/

public class SignalCounter {

    private int signals = 0;
    private int threadsWaiting = 0;

    public void doNotify(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" calling notify()");
            if(this.threadsWaiting == 0){
                this.signals++;
            }
            this.notify();
            System.out.println(Thread.currentThread().getName()+" exited notify()");
        }
    }

    public void doWait() throws InterruptedException{
        synchronized (this){
            if(this.signals >= 0){
                System.out.println(Thread.currentThread().getName()+" "+this.signals+" signals were already raised - decrementing signals and returning");
                this.signals--;
                return;
            }
            System.out.println(Thread.currentThread().getName()+" calling wait()");
            this.threadsWaiting++;
            this.wait();
            this.threadsWaiting--;
            System.out.println(Thread.currentThread().getName()+" exited wait()");
        }
    }
}
