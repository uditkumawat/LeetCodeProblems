package code.leetcode.doordash;

import java.util.*;

/**
 * There are two key observations to make:
 *
 * For each job we want to find all chains that end before the current job's start time.
 * Since the jobs are sorted according to start time if a chain does not conflict with the current job, then it will also not conflict with any future job.
 */
//TC - O(nlogn)
//SC - O(N)
public class MaximumProfitInJobScheduling {


    public static void main(String args[]){

        int startTime[] = {1,2,3,3};
        int endTime[] = {3,4,5,6};
        int profit[] = {50,10,40,70};

        System.out.println(jobScheduling(startTime,endTime,profit));

    }

    static class Job{
        int startTime;
        int endTime;
        int profit;
        Job(int startTime,int endTime,int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        if(startTime==null || startTime.length==0){
            return 0;
        }

        int n = startTime.length;

        List<Job> jobs = new ArrayList<>();

        for(int i=0;i<n;i++){
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        }

        Collections.sort(jobs,(a, b)->a.startTime-b.startTime);

        int maxProfit = Integer.MIN_VALUE;

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<jobs.size();i++){
            int currentStartTime = jobs.get(i).startTime;
            int currentEndTime = jobs.get(i).endTime;
            int currentProfit = jobs.get(i).profit;
            Integer entryTillCurrentStartTime = map.floorKey(currentStartTime);
            Integer profitTillCurrentStartTime = entryTillCurrentStartTime==null?0:map.get(entryTillCurrentStartTime);

            maxProfit = Math.max(maxProfit,profitTillCurrentStartTime+currentProfit);
            map.put(currentEndTime,maxProfit);
        }

        return maxProfit;
    }
}
