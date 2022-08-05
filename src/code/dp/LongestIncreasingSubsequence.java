package code.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int n = nums.length;

        int lis[] = new int[n];
        Arrays.fill(lis,1);

        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && lis[i]<lis[j]+1){
                    lis[i] = lis[j]+1;
                    max = Math.max(max,lis[i]);
                }
            }
        }

        return max;
    }
}
