package code.dp;

//https://leetcode.com/problems/min-cost-climbing-stairs/
//TC - O(N)
//SC - O(N)
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int minimumCost[] = new int[cost.length+1];

        for(int i=2;i<minimumCost.length;i++){
            int takeOneStep = minimumCost[i-1] + cost[i-1];
            int takeTwoStep = minimumCost[i-2] + cost[i-2];
            minimumCost[i] = Math.min(takeOneStep,takeTwoStep);
        }

        return minimumCost[minimumCost.length-1];
    }
}
