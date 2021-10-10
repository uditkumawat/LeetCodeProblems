package code.top100;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverageFromDataStream {

    public static void main(String args[]){
        MovingAverageFromDataStream obj = new MovingAverageFromDataStream(3);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }

    Queue<Integer> q;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
       q = new LinkedList<Integer>();
       this.size = size;
       this.sum = 0;
    }

    public double next(int val) {
        if(q.size()==size){
            sum = sum - q.remove();
        }
        sum+=val;
        q.add(val);
        return sum*1.0/q.size();
    }
}
