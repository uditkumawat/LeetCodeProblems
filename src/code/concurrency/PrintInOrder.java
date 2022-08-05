package code.concurrency;

import java.util.concurrent.Semaphore;

//https://leetcode.com/problems/print-in-order/submissions/

public class PrintInOrder {

    private Semaphore semaphore[];
    public PrintInOrder() {

        int numOfThreads = 3;
        semaphore = new Semaphore[numOfThreads];

        try{
            for(int i=0;i<numOfThreads;i++){
                semaphore[i] = new Semaphore(1,true);

                semaphore[i].acquire();
            }

            semaphore[0].release();
        }catch(InterruptedException ex){

        }
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        semaphore[0].acquire();
        printFirst.run();
        semaphore[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        semaphore[1].acquire();
        printSecond.run();
        semaphore[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        semaphore[2].acquire();
        printThird.run();
        semaphore[0].release();
    }


}
