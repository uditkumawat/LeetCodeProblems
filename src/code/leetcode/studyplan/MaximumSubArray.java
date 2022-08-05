package code.leetcode.studyplan;

//https://leetcode.com/problems/maximum-subarray/submissions/
//TC - O(N)
//SC - O(1)
//https://www.youtube.com/watch?v=RcRUCCm9oos
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int currSum = nums[0];
        int maxTillNow = nums[0];
        int max;

        for(int i=1;i<nums.length;i++){

            if(currSum<0){
                currSum = 0;
            }

            currSum = currSum + nums[i];

            maxTillNow = Math.max(maxTillNow,currSum);
        }

        return maxTillNow;
    }
}
