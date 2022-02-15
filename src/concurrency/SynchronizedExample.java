package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException {
        /*When we are working on shared data with multithreading, we should be careful. There can be errors that we should deal with. One of them is:
            -Thread interference errors :It happens when multiple thread try to reach shared variable.
          */

        Counter counter = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++){
            executorService.submit(counter::increment);
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final count is : " + counter.getCount()); //We expect the result will be 1000, but it won't. This is Thread interference errors.

        //To solve this we can use synchronized keyword.

        Counter counterSync = new Counter();
        ExecutorService executorServiceSync = Executors.newFixedThreadPool(10);
        for (int y=0; y<1000;y++){
            executorServiceSync.submit(counterSync::syncIncrement);
        }
        executorServiceSync.shutdown();
        executorServiceSync.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Final count of synchronized increment is : " + counterSync.getCount());

    }
}

class Counter {
    int count = 0;

    public void increment() {
        count = count + 1;
    }

    public synchronized void syncIncrement() { //synchronized keyword make sure onyl one thread can enter the syncIncrement method at one time.
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}
