package concurrency.volatileTutorial;

public class VolatileCounter {
    private volatile long counter; //volatile takes 59 sec
    VolatileCounter(){
        this.counter=0;
    }
    public void increment(){
        this.counter++;
    }

    public long getCounter(){
        return this.counter;
    }
}
