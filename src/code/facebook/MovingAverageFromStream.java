package code.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromStream {

    int sum = 0;
    int size = 0;
    Queue<Integer> q;

    public static void main(String args[]){

        MovingAverageFromStream obj = new MovingAverageFromStream(3);

        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));

    }
    /** Initialize your data structure here. */
    public MovingAverageFromStream(int size) {
        this.size = size;
        this.sum = 0;
        this.q = new LinkedList<>();
    }

    public double next(int val) {
        sum = sum+val;
        q.add(val);
        if(q.size()>this.size){
            sum = sum - q.poll();
        }
        return sum*1.0/q.size();
    }
}
