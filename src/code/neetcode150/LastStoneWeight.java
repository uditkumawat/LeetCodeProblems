package code.neetcode150;

import java.util.PriorityQueue;

//https://leetcode.com/problems/last-stone-weight/
//TC - O(nlogn)
//SC - O(n)
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return b-a;
        });

        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();

            if(first!=second){
                pq.add(first-second);
            }
        }

        return pq.isEmpty()?0:pq.poll();
    }
}
