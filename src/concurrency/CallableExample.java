package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {

    static Callable<String> callableHelper(String taskName, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return taskName;
        };
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        /*Callables are functional interfaces like Runnables. Unlike Runnanbles, Callables returns a value*/
        Callable<String> sayMyNameTask=()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                return "My name is Heisenberg";
            }
            catch (InterruptedException e){
                throw new IllegalStateException("task interrupted", e);
            }
        };

        /*In executer service .submit() doesn't wait until task is finished. To get value from the task, we need to use Future interface.
         This interface provides functions like .get(), isDone() etc. In this way, we can check the task and its return value. */
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> futureResult = executorService.submit(sayMyNameTask);

        System.out.println("Result is done: "+futureResult.isDone());

        String result = futureResult.get();// blocks the current thread until task is done. If we try to get future after terminate the executer, future will throw an error.
        //or
        result= futureResult.get(1,TimeUnit.SECONDS);
        /*Using .get() like above can cause infinite loop. To prevent this situation, we can use different version of .get() with timeout.
        If the task is not complete when the time is up, Future will throw an TimeoutException.  */

        System.out.println("Result is done: "+futureResult.isDone());
        System.out.println(result);
        executorService.shutdown();

        //We can pass a list of callable task to executer service with invokeAll() function.
        List<Callable<Integer>> callableTaskList = Arrays.asList(
                ()->1,
                ()->2,
                ()->3
        );
        ExecutorService executorServiceForManyTask = Executors.newWorkStealingPool();
        executorServiceForManyTask.invokeAll(callableTaskList)
                .stream().map(future->{
                    try {
                        return  future.get();
                    }catch (Exception e){
                        throw new IllegalStateException(e);
                    }
                }).forEach(System.out::println);

        executorServiceForManyTask.shutdown();

        //Another way to pass multiple task to executer service is invokeAny() function. It returns the fastest task. Task2 in this example:
        List<Callable<String>> callableListForInAny = Arrays.asList(
                callableHelper("Task2",1),
                callableHelper("Task1",5),
                callableHelper("Task3",4)
        );
        ExecutorService executorServiceForInAny = Executors.newSingleThreadExecutor();
        String inAnyResult =executorServiceForInAny.invokeAny(callableListForInAny);
        System.out.println(inAnyResult);
        executorServiceForInAny.shutdown();
    }

}
