package code.leetcode.studyplan75;

//https://leetcode.com/problems/running-sum-of-1d-array/submissions/
//TC - O(N)
//SC - O(1)
public class RunningSumOf1DArray {

    public int[] runningSum(int[] nums) {

        if(nums==null || nums.length<=1){
            return nums;
        }

        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i-1]+nums[i];
        }

        return nums;
    }
}
