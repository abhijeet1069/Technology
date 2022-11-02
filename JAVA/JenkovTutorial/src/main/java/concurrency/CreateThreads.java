package concurrency;
/*
Code that is safe to call by multiple threads simultaneously is called thread safe.
* */


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

    public static void main(String[] args) {
        Thread thread = new Thread(createThread(), "Print thread");
        thread.start();
    }
}
