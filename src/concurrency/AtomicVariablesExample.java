package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesExample {
    public static void main(String[] args) throws InterruptedException {
        /*Atomic variables are used to avoid Thread interference errors and Memory consistency errors. Atomic variables are faster then locks.*/
        AtomicCounter atomicCounter = new AtomicCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i =0; i<1000;i++){
            executorService.submit(atomicCounter::increment);
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final Count is : " + atomicCounter.getCount());
    }
}

class AtomicCounter{
    AtomicInteger count = new AtomicInteger(0);
    public int increment(){
        return count.incrementAndGet();
    };
    public  int getCount(){
        return  count.get();
    }
}
