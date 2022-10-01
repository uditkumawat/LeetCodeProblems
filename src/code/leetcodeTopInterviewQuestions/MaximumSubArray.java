package code.leetcodeTopInterviewQuestions;

//https://leetcode.com/problems/maximum-subarray/submissions/
//TC - O(N)
//SC - O(1)
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int currentSubArray = nums[0];
        int maxSoFar = nums[0];

        for(int i=1;i<nums.length;i++){
            currentSubArray = Math.max(nums[i],currentSubArray+nums[i]);
            maxSoFar = Math.max(maxSoFar,currentSubArray);
        }

        return maxSoFar;
    }
}
