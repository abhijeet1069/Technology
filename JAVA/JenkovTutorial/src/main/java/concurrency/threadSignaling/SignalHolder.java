package concurrency.threadSignaling;

/**
    To remove lost signal issue. we store the signal in a variable.
    But since, the variable is boolean. multiple notify signals will also be lost.
 **/

public class SignalHolder {
    private boolean signalRaised = false;
    private boolean isThreadWaiting = false;

    public void doNotify(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" calling notify()");
            if(!this.isThreadWaiting){
                this.signalRaised = true;
            }
            this.notify();
            System.out.println(Thread.currentThread().getName()+" exited notify()");
        }
    }

    public void doWait() throws InterruptedException{
        synchronized (this){
            if(this.signalRaised){
                System.out.println(Thread.currentThread().getName()+" signal was already");
                this.signalRaised = false;
                return;
            }
            System.out.println(Thread.currentThread().getName()+" calling wait()");
            this.isThreadWaiting = true;
            this.wait();
            this.isThreadWaiting = false;
            System.out.println(Thread.currentThread().getName()+" exited wait()");
        }
    }
}
