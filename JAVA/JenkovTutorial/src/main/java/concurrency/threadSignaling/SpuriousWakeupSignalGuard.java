package concurrency.threadSignaling;

/**
 Spurious Wakeup - Sometimes, in JVM a thread may exit wait() even without any notify() call
 **/

public class SpuriousWakeupSignalGuard {

    Object myMonitorObject = new Object();
    boolean wasSignaled = false;

    public void doNotify(){
        synchronized (myMonitorObject){
            wasSignaled = true;
            myMonitorObject.notify();
        }
    }

    public void doWait() throws InterruptedException{
        synchronized (myMonitorObject){
            while(!wasSignaled){ //guards against spurious wakeup
                myMonitorObject.wait();
            }
            //clear signal and continue running
            wasSignaled = false;
        }
    }
}
