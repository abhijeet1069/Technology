package concurrency.threadSignaling;

public class SignalCarrier {

    public void doWait() throws InterruptedException{
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" calling wait()");
            this.wait();
            System.out.println(Thread.currentThread().getName()+ " exited wait()");
        }
    }

    public void doNotify(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" calling notify()");
            this.notify();
            System.out.println(Thread.currentThread().getName()+" exited notify()");
        }
    }

    public void doNotifyAll(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" calling notify()");
            this.notifyAll();
            System.out.println(Thread.currentThread().getName()+" exited notify()");
        }
    }

    public static void main(String[] args) {
        SignalCarrier signalCarrier = new SignalCarrier();
        Thread waiter = new Thread(()->{
           try{
               signalCarrier.doWait();
           }catch(InterruptedException e){
               e.printStackTrace();
           }
        });

        Thread notifier = new Thread(()->{
            signalCarrier.doNotify();
        });

        waiter.start();
        notifier.start();

        //notifier.start(); //Lost signal: notifier notifies but, wait doesn't catch it and is stuck in wait forever
        //waiter.start();
    }
}
