package code.leetcode.queuesStacks;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/moving-average-from-data-stream/
//TC - O(1)
//SC - O(size)
public class MovingAverageFromStream {

    int size = 0;
    int sum = 0;
    Queue<Integer> q;

    public MovingAverageFromStream(int size) {
        this.q = new LinkedList<Integer>();
        this.sum = 0;
        this.size = size;
    }

    public double next(int val) {
        sum = sum + val;
        q.add(val);
        if(this.q.size()>this.size){
            sum = sum - q.remove();
        }
        return sum*1.0/q.size();
    }
}
