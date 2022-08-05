package code.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorInvokeAll {

    public static void main(String args[]) throws InterruptedException, ExecutionException {

        Callable<String> callable1 = ()->{
            System.out.println("First callable1 -> "+Thread.currentThread().getName());
            return "callable1";
        };

        Callable<String> callable2 = ()->{
            System.out.println("Second callable2 -> "+Thread.currentThread().getName());
            return "callable2";
        };

        Callable<String> callable3 = ()->{
            System.out.println("Third callable3 -> "+Thread.currentThread().getName());
            return "callable3";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(callable1,callable2,callable3));

        for(Future<String> f:futures){
            System.out.println(f.get());
        }

        executorService.shutdown();
    }
}
