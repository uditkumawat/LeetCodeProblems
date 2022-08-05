package code.amazon;

//https://leetcode.com/problems/maximum-subarray/solution/
public class MaximumSubArray {


    public int maxSubArray(int[] nums) {

        int currSubArray = nums[0];
        int maxSubArray = nums[0];

        for(int i=1;i<nums.length;i++){
            int num = nums[i];

            currSubArray = Math.max(num,currSubArray+num);
            maxSubArray = Math.max(maxSubArray,currSubArray);
        }

        return maxSubArray;
    }
}
