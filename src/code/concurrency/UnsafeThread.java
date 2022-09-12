package code.concurrency;


public class UnsafeThread {

    static class Counter{

        int value;

        Counter(){
            this.value = 0;
        }

        public void increment(){
            value++;
        }

        public void decrement(){
            value--;
        }

        public void printValue(){
            System.out.println("Current value "+value);
        }
    }

    public static void main(String args[]) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++){
                counter.increment();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<100;i++){
                counter.decrement();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        counter.printValue();
    }
}
