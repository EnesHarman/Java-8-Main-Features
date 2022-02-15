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

        //If we use multiple threads and if we want to wait until first thread is done, we can use .join() method.

        Thread firstThread = new Thread(()->{
            System.out.println("The first thread is starting.");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("The first thread is done!");
        });

        Thread secondThread = new Thread(()->{
            System.out.println("The second thread is starting.");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("The second thread is done!");
        });

        firstThread.start();
        try {
            firstThread.join(2000); //it will wait 2000 second before second thread start. Without parameter join() will wait until first thread is done.
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        secondThread.start();

        // Creating threads like above is not safe and easy. There is a solution in  the Concurrency API. That named Executer

        //Creating threads with Executer
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //Executers class provides many methods to create different types of executer services.
        executorService.submit(sleepingRunnableTask);
        executorService.shutdown(); /*Executers have to be stopped by functions like .shutdown() of .shutdownnow(). Otherwise it will keep listening...*/

    }
}
