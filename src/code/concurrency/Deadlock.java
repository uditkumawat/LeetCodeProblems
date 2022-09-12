package code.concurrency;

//https://www.javatpoint.com/deadlock-in-java
public class Deadlock {

    public static void main(String args[]) throws InterruptedException {

        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread t1 = new Thread(()->{
            System.out.println("Thread 1 trying to acquire lock on Obj1");
           synchronized (obj1){
               try {
                   System.out.println("Thread 1 got lock on Obj1");
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("Thread 1 trying to acquire lock on Obj2");
               synchronized (obj2){
                   try {
                       System.out.println("Thread 1 got the lock on Obj2");
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        });

        Thread t2 = new Thread(()->{
            System.out.println("Thread 2 trying to acquire lock on Obj2");
            synchronized (obj2){
                try {
                    System.out.println("Thread 2 got lock on Obj2");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2 trying to acquire lock on Obj1");
                synchronized (obj1){
                    try {
                        System.out.println("Thread 2 got the lock on Obj1");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
