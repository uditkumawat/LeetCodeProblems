package code.june.challenge;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=W_OYx6Ajh-k
//https://leetcode.com/problems/furthest-building-you-can-reach/submissions/
//TC - O(nlogn)
//SC - O(ladders)
public class FarthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<heights.length-1;i++){

            int gap = heights[i+1]-heights[i];
            if(gap>0){
                pq.add(gap);
            }

            if(pq.size()>ladders){
                bricks -= pq.remove();
            }

            if(bricks<0){
                return i;
            }
        }

        return heights.length-1;
    }
}
