package code.thread;

import java.util.concurrent.*;

//https://www.callicoder.com/java-callable-and-future-tutorial/
public class FirstCallable {

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        Callable<String> callable = ()->{
            System.out.println("Inside thread -> "+Thread.currentThread().getName());
            Thread.sleep(2000);
            return "Hello";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(callable);
        System.out.println("Do something else while callable is getting executed");
        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        System.out.println(future.get());
        executorService.shutdown();

    }
}
