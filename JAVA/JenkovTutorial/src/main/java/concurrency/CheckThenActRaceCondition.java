package concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CheckThenActRaceCondition {
    public static Runnable getRunnable(Map<String, String> sharedMap){
        return ()->{
            for(int i = 0; i < 100; i++) {
                synchronized (sharedMap) { //removing this synchronized causes race condition
                    if (sharedMap.containsKey("key")) {
                        String val = sharedMap.remove("key");
                        if (val == null)
                            System.out.println("Iteration: " + i + " Value of 'key' was null");
                        else
                            System.out.println("Iteration: " + i + " Found key: "+val);
                    } else{
                        sharedMap.put("key", "value");
                    }

                }
            }
        };
    }

    public static void main(String[] args) {
        Map<String, String> sharedMap = new ConcurrentHashMap<>(); //can be accessed by multiple threads
        Thread t1 = new Thread(getRunnable(sharedMap));
        Thread t2 = new Thread(getRunnable(sharedMap));
        t1.start();
        t2.start();
    }
}
