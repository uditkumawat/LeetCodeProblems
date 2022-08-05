package code.thread;


public class FirstThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello from run method , thread -> "+Thread.currentThread().getName());
    }

    /**   //we cna provide thread name also
    FirstThread(String newThreadname){
        super(newThreadname);
    }*/

    public static void main(String args[]){

        System.out.println("Inside thread -> "+Thread.currentThread().getName());

        FirstThread obj = new FirstThread();

        obj.start();
    }
}
