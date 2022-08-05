package code.leetcode.studyplan75;

//https://leetcode.com/problems/maximum-product-subarray/solution/
//TC - O(N)
//SC - O(!)
//https://www.youtube.com/watch?v=lXVy6YWFcRM
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }
        int ans = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            int tempMax = Math.max(curr,Math.max(maxSoFar*curr,minSoFar*curr));
            minSoFar = Math.min(curr,Math.min(maxSoFar*curr,minSoFar*curr));
            maxSoFar = tempMax;
            ans = Math.max(ans,maxSoFar);
        }

        return ans;
    }
}
