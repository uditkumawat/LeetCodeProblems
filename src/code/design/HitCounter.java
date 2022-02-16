package code.design;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/design-hit-counter/
public class HitCounter {

    Queue<Integer> q;
    public HitCounter() {
        q = new LinkedList<>();
    }

    public static void main(String args[]){

        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        System.out.println(obj.getHits(4));
        obj.hit(300);
        System.out.println(obj.getHits(300));
        System.out.println(obj.getHits(301));

    }

    public void hit(int timestamp) {
        q.add(timestamp);
    }

    public int getHits(int timestamp) {
        while(!q.isEmpty()){
            int diff = timestamp-q.peek();
            if(diff>=300){
                q.poll();
            }
            else{
                break;
            }
        }
        return q.size();
    }
}
