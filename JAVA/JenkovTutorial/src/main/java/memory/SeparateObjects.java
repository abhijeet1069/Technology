package memory;

public class SeparateObjects {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable2, "Thread 2");

        thread1.start(); //Thread 1 : 10000000
        thread2.start(); //Thread 2 : 10000000
    }
}
