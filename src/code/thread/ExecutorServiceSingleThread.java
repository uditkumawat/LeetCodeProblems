package code.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/
public class ExecutorServiceSingleThread {

    public static void main(String args[]) {

        System.out.println("Main thread -> " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnable = ()->{
          System.out.println("Thread -> "+Thread.currentThread().getName());
        };

        executorService.submit(runnable);

        //always remember to shutdown the executor service, otherwise it will wait for another work
        executorService.shutdown();
    }
}
