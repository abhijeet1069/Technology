package timing;

public class TimeProgram {

    public static int square(int num) throws InterruptedException {
        Thread.sleep(1000);
        return num*num;
    }

    public static void main(String[] args) throws InterruptedException {
        final long startTime = System.currentTimeMillis();

        System.out.println("Square: "+square(12));

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time(sec): "+(endTime-startTime)/1000.0);
    }
}
