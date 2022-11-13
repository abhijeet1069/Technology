package concurrency.falseSharing;

public class Counter3 {
    @jdk.internal.vm.annotation.Contended("group1") //group contended annotation. Same groups will have same cache lines.
    public volatile long count1 = 0;

    @jdk.internal.vm.annotation.Contended("group1")
    public volatile long count2 = 0;

    @jdk.internal.vm.annotation.Contended("group2")
    public volatile long count3 = 0;
}
