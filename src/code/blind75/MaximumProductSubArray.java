package code.blind75;

//https://www.youtube.com/watch?v=fOUieZzRuAk
//TC- O(N)
//SC -O(1)
public class MaximumProductSubArray {

    public int maxProduct(int nums[]){

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int res = Integer.MIN_VALUE;
        
        for(int i=1;i<nums.length;i++){
            int temp = maxSoFar;
            maxSoFar = Math.max(nums[i],Math.max(maxSoFar*nums[i],minSoFar*nums[i]));
            minSoFar = Math.min(nums[i],Math.min(minSoFar*nums[i],temp*nums[i]));

            res = Math.max(res,maxSoFar);
        }

        return res;

    }
}
