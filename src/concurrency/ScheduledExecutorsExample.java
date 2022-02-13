package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsExample {
    /* A ScheduledExecutor can run tasks with order, it can use delay time before run the task*/
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable runnableTask = ()-> System.out.println("A runnable task.");
        ScheduledFuture<?> future =  scheduledExecutorService.schedule(runnableTask,2, TimeUnit.SECONDS);
        System.out.println( future.getDelay(TimeUnit.MILLISECONDS));
        scheduledExecutorService.shutdown();
    }
}
