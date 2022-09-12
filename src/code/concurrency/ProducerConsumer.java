package code.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    static class DataStore{
        private int storeSize;
        private Queue<Integer> queue;
        DataStore(int size){
            this.storeSize  = size;
            this.queue = new LinkedList<Integer>();
        }

        public synchronized void put(int value) throws InterruptedException {

            if(this.storeSize==this.queue.size()){
                wait();
            }
            this.queue.add(value);
            System.out.println(Thread.currentThread().getName()+" Produced value "+value);
            notifyAll();
        }

        public synchronized int get() throws InterruptedException {
            if(this.queue.isEmpty()){
                wait();
            }
            int data = this.queue.remove();
            notifyAll();
            return data;
        }
    }

    static class Producer implements Runnable{

        public DataStore ds;
        public int maxNumber;

        Producer(int maxNumber,DataStore ds){
            this.maxNumber = maxNumber;
            this.ds = ds;
        }

        @Override
        public void run(){
            for(int i=0;i<maxNumber;i++){
                try {
                    ds.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        public DataStore ds;
        public int maxNumber;
        Consumer(int maxNumber,DataStore ds){
            this.ds = ds;
            this.maxNumber = maxNumber;
        }
        @Override
        public void run(){
            for(int i=0;i<maxNumber;i++) {
                try {
                    System.out.println(Thread.currentThread().getName()+" Consumed value "+ds.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        DataStore ds = new DataStore(10);
        Producer pd = new Producer(20,ds);
        Consumer consumer = new Consumer(20,ds);

        Thread t1 = new Thread(pd,"ProducerThread");
        Thread t2 = new Thread(consumer,"ConsumerTthread");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
