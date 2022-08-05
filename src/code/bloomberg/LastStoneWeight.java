package code.bloomberg;

import java.util.PriorityQueue;

//https://leetcode.com/problems/last-stone-weight/submissions/
//TC - O(nlogn)
//SC - O(n)
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1, i2)->{
            return i2-i1;
        });

        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size()>=2){
            int first = pq.poll();
            int second = pq.poll();

            if(first!=second){
                first = first-second;
                pq.add(first);
            }
        }

        return pq.isEmpty()?0:pq.poll();
    }
}
