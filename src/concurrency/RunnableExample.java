package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableExample {
    public static void main(String[] args) {

        Runnable simpleRunnableTask = ()-> System.out.println("I'm a runnable task");
        MyThread myThread1 = new MyThread(simpleRunnableTask,1);
        myThread1.start();

        Runnable sleepingRunnableTask= ()->{
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Thread name : "+name+" is sleeping...");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Thread name : "+name+" is awaking...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        MyThread myThread2 = new MyThread(sleepingRunnableTask,2);
        myThread2.start();

        // Creating threads like above is not safe and easy. There is a solution in  the Concurrency API. That named Executer

        //Creating threads with Executer
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //Executers class provides many methods to create different types of executer services.
        executorService.submit(sleepingRunnableTask);
        executorService.shutdown(); /*Executers have to be stopped by functions like .shutdown() of .shutdownnow(). Otherwise it will keep listening...*/

    }
}
