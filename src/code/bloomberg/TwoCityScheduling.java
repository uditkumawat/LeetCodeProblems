package code.bloomberg;

import java.util.Arrays;

///https://leetcode.com/problems/two-city-scheduling/submissions/
//TC - O(nlogn)
//SC - O(1)
//https://www.youtube.com/watch?v=3isvpHf5_MM
public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs,(a, b)->{
            return (a[0]-a[1])-(b[0]-b[1]);
        });

        int cost = 0;

        for(int i=0;i<costs.length;i++){
            if(i<costs.length/2){
                cost = cost + costs[i][0];
            }
            else{
                cost = cost + costs[i][1];
            }
        }

        return cost;
    }
}
