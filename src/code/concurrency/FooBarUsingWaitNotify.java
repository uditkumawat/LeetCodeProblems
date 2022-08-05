package code.concurrency;

//https://leetcode.com/problems/print-foobar-alternately/discuss/1118149/JAVA-Very-Simple-Synchronized-Solution
public class FooBarUsingWaitNotify {

    private int n;
    private boolean runFoo;

    public FooBarUsingWaitNotify(int n){
        this.n = n;
        this.runFoo = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for(int i=0;i<n;i++) {
            synchronized (this) {
                while (!runFoo) {
                    wait();
                }
                printFoo.run();
                runFoo = false;
                notify();
            }
        }
    }


    public void bar(Runnable printbar) throws InterruptedException {

        for(int i=0;i<n;i++) {
            synchronized (this) {
                while (runFoo) {
                    wait();
                }
                printbar.run();
                runFoo = true;
                notify();
            }
        }
    }
}
