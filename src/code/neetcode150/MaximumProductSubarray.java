package code.neetcode150;

//https://leetcode.com/problems/maximum-product-subarray/
//TC - O(N)
//SC - O(1)
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int res = max_so_far;

        for(int i=1;i<nums.length;i++){

            int num = nums[i];

            int temp = Math.max(num,Math.max(max_so_far*num,min_so_far*num));
            min_so_far = Math.min(num,Math.min(max_so_far*num,min_so_far*num));

            max_so_far = temp;

            res = Math.max(res,max_so_far);
        }

        return res;
    }
}
