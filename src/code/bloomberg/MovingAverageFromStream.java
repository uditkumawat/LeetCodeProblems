package code.bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromStream {

    int size;
    int sum;
    Queue<Integer> q;
    public MovingAverageFromStream(int size) {
        this.q = new LinkedList();
        this.sum = 0;
        this.size = size;
    }

    public double next(int val) {
        q.add(val);
        sum = sum + val;
        while(q.size()>size){
            sum = sum - q.poll();
        }
        return sum*1.0/q.size();
    }
}
