package code.concurrency;

import java.util.concurrent.Semaphore;

//https://leetcode.com/problems/print-foobar-alternately/
public class FooBar {

    private int n;
    Semaphore semFoo = new Semaphore(1);
    Semaphore semBar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            semFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            semBar.acquire();
            printBar.run();
            semFoo.release();
        }
    }
}
