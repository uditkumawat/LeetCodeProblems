package code.dp;

//https://leetcode.com/problems/maximum-subarray/solution
//TC - O(N)
//SC - O(1)
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int maxSum = 0;
        int currSum = 0;

        for(int i=0;i<nums.length;i++){
            currSum = Math.max(nums[i],currSum + nums[i]);

            maxSum = Math.max(maxSum,currSum);
        }

        return maxSum;
    }
}
