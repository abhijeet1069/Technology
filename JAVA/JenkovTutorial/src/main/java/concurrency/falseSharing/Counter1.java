package concurrency.falseSharing;

public class Counter1 {
    public volatile long count1 = 0;
    public volatile long count2 = 0;
}
