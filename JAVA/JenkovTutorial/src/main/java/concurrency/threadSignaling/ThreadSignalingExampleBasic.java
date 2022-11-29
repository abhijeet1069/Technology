package concurrency.threadSignaling;

public class ThreadSignalingExampleBasic {
    public static void main(String[] args) {
        Object signalObject = new Object(); //Object class is the superclass of all objects in JAVA
        Thread waitingThread = new Thread(()->{
           synchronized (signalObject){
               try {
                   signalObject.wait(); //wait till interrupt or other thread sends notify, notifyAll
               }catch (Exception e){ //wait also releases the lock on signalObject. Else below thread will not be able to execute
                   e.printStackTrace();
               }
           }
        });
        Thread notifyingThread = new Thread(()->{
           synchronized (signalObject){
               signalObject.notify(); //note only synchronized object are able to use notify(), wait(), notifyAll() methods
           }
        });

        waitingThread.start();
        notifyingThread.start();
    }
}
