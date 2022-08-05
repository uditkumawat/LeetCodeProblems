package code.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/
public class ExecutorServiceFixedThreadPool {

    public static void main(String args[]){

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable1 = ()->{
            System.out.println("Thread 1 -> "+Thread.currentThread().getName());
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable2 = ()->{
            System.out.println("Thread 2 -> "+Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable3 = ()->{
            System.out.println("Thread 3 -> "+Thread.currentThread().getName());
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executorService.submit(runnable1);
        executorService.submit(runnable2);
        executorService.submit(runnable3);

        executorService.shutdown();
    }
}
