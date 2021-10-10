package code.microsoft;

import java.util.concurrent.Semaphore;

public class PrintInOrder {

    private Semaphore semaphore[];
    public PrintInOrder() {
        int numOfThreads = 3;
        semaphore = new Semaphore[numOfThreads];

        try {
            for (int i = 0; i < numOfThreads; i++) {
                semaphore[i] = new Semaphore(1, true);

                semaphore[i].acquire();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore[0].release();
    }

    public void first(Runnable printFirst) throws InterruptedException {

        semaphore[0].acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        semaphore[1].acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        semaphore[2].acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        semaphore[0].release();
    }
}
