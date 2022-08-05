package code.thread;

//https://www.callicoder.com/java-multithreading-thread-and-runnable-tutorial/
public class FirstRunnable {

    public static void main(String args[]){

        System.out.println("Inside : " + Thread.currentThread().getName());
        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                System.out.println("New thread ->"+Thread.currentThread().getName());
            }
        };

        Thread th1 = new Thread(runnable);
        th1.start();

        Runnable runnable2 = ()->{
                System.out.println("New thread ->"+Thread.currentThread().getName());
        };

        Thread th2 = new Thread(runnable2);
        th2.start();
    }
}
