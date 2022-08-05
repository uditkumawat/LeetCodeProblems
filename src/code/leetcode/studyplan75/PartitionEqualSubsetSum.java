package code.leetcode.studyplan75;

//https://leetcode.com/problems/partition-equal-subset-sum/submissions/
//TC - O(n*sum)
//SC - O(n*sum)
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        if(nums==null || nums.length==0){
            return true;
        }

        int sum = 0;
        for(int num:nums){
            sum+=num;
        }

        //sum is odd
        if((sum & 1)==1){
            return false;
        }

        sum = sum/2;

        Boolean memo[][] = new Boolean[nums.length+1][sum+1];

        return subSetSum(nums,nums.length,sum,memo);
    }

    public boolean subSetSum(int nums[],int n,int sum,Boolean memo[][]){
        if(sum==0){
            return true;
        }
        if(n==0 || sum<0){
            return false;
        }
        if(memo[n][sum]!=null){
            return memo[n][sum];
        }

        boolean result = subSetSum(nums,n-1,sum-nums[n-1],memo) || subSetSum(nums,n-1,sum,memo);

        memo[n][sum] = result;

        return result;
    }
}
