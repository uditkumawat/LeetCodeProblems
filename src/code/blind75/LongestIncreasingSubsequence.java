package code.blind75;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/submissions/
//TC - O(n^2)
//SC - O(n)
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int dp[] = new int[nums.length];

        Arrays.fill(dp,1);
        int max = 1;

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
