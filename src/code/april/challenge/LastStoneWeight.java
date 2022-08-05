package code.april.challenge;

import java.util.PriorityQueue;

//https://leetcode.com/problems/last-stone-weight/solution/
//TC - O(nlogn) -- we are inserting all N elements into heap with logN operation, so NlogN
//SC - O(n) - to create priorityQueue
public class LastStoneWeight {

    public static void main(String args[]){

        int stones[] = {2,7,4,1,8,1};

        LastStoneWeight obj = new LastStoneWeight();

        System.out.println(obj.lastStoneWeight(stones));
    }
    public int lastStoneWeight(int[] stones) {

        if(stones==null || stones.length==0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((w1, w2)->{
            return w2-w1;
        });

        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size()>1){
            int firstStone = pq.poll();
            int secondStone = pq.poll();

            if(firstStone!=secondStone){
                pq.add(firstStone-secondStone);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
