package code.august2022.challenge;

import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-number-of-refueling-stops/
//TC - O(nlogn)
//SC - O(N) - in case we have to push all gas stations
//https://www.youtube.com/watch?v=tAdMNnd3CII
public class MinimumNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int xCurrent = startFuel;
        int noOfStops = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return b-a;
        });

        for(int station[]:stations){

            int nextStation = station[0];
            int fuelAtStation = station[1];

            while(xCurrent<nextStation){
                if(pq.isEmpty()){
                    return -1;
                }
                int maxFuel = pq.poll();
                xCurrent = xCurrent + maxFuel;
                noOfStops++;
            }

            pq.offer(fuelAtStation);
        }

        while(xCurrent<target){
            if(pq.isEmpty()){
                return -1;
            }
            int maxFuel = pq.poll();
            xCurrent = xCurrent + maxFuel;
            noOfStops++;
        }

        return noOfStops;
    }
}
