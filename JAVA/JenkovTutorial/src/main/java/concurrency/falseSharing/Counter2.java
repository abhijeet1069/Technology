package concurrency.falseSharing;

public class Counter2 {
    //store variable in different cpu cache line
    @jdk.internal.vm.annotation.Contended
    public volatile long count1 = 0;

    public volatile long count2 = 0;

}
