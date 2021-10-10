package code.top100;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy
public class MinimumNumberOfRefuelingSteps {

    public int minRefuelSteps(int target,int startFuel,int stations[][]){

        if(startFuel>=target){
            return 0;
        }

        Queue<Integer> pq = new PriorityQueue<Integer>((a, b)->(b-a));
        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;

        while(maxDistance<target){
            while(i<n && stations[i][0]<=maxDistance){
                pq.add(stations[i++][1]);
            }
            if(pq.isEmpty()){
                return -1;
            }
            maxDistance+=pq.poll();
            stops++;
        }
        return stops;
    }
}
