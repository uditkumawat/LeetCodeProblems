package code.salesforce;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
//https://www.youtube.com/watch?v=8t8TeyRJDvk
public class PartitionToKEqualSumSubset {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int tsum = 0;
        for(int num:nums){
            tsum = tsum + num;
        }

        if(tsum % k!=0){
            return false;
        }

        int n = nums.length;
        int subsetSum = tsum/k;
        boolean visited[] = new boolean[n];

        return util(nums,visited,0,k,0,subsetSum);
    }


    public boolean util(int nums[],boolean visited[],int start,int k,int currSum,
                        int sum){
        if(k==0){
            return true;
        }
        if(currSum>sum){
            return false;
        }
        if(currSum==sum){
            return util(nums,visited,0,k-1,0,sum);
        }

        for(int end = start;end<nums.length;end++){
            if(visited[end]){
                continue;
            }
            visited[end] = true;
            if(util(nums,visited,end,k,currSum + nums[end],sum)){
                return true;
            }
            visited[end] = false;
        }

        return false;
    }
}
