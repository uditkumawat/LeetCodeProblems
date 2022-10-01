package code.september2022.challenge;

///https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/
//TC - O(m*n)
//SC - O(m*n)
public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {

        if(nums1==null && nums2==null){
            return 0;
        }

        int m = nums1.length;
        int n = nums2.length;

        int dp[][] = new int[m+1][n+1];

        int maxLength = 0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    maxLength = Math.max(maxLength,dp[i][j]);
                }
            }
        }

        return maxLength;
    }
}
