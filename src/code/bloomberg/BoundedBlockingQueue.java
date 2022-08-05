package code.bloomberg;

import java.util.Deque;
import java.util.LinkedList;

public class BoundedBlockingQueue {

    Deque<Integer> dq;
    int size;
    Object lock;

    BoundedBlockingQueue(int capacity){
        this.size = capacity;
        this.dq = new LinkedList<Integer>();
        this.lock = new Object();
    }


    public void enqueue(int element) throws InterruptedException {

        synchronized (lock){
            while(dq.size()==size){
                lock.wait();
            }
            dq.add(element);
            lock.notify();
        }
    }

    public int deque() throws InterruptedException {
        int val = 0;
        synchronized (lock){
            while(!dq.isEmpty()){
                lock.wait();
            }
            val = dq.removeFirst();
            lock.notify();
        }
        return val;
    }
}
