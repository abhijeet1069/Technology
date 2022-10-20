package thread;

class MyThread extends Thread{
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+" : Going to sleep...");
            sleep(3000);
            System.out.println(Thread.currentThread().getName()+" : Awake");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

/*  Without join, program was executing in 3 sec, When first join was added, program time increased to 6 sec
    When second join was added, program time increased to 9 sec
* */

public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread0 = new MyThread();
        thread0.start();
        thread0.join();

        MyThread thread1 = new MyThread();
        thread1.start();
        thread1.join();

        MyThread thread2 = new MyThread();
        thread2.start();
    }
}
