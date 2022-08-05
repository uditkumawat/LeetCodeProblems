package code.blind75;

//https://leetcode.com/problems/product-of-array-except-self/submissions/
//TC - O(N)
//SC - O(1)
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        int prod[] = new int[nums.length];

        //prod[i] will contain the product of all elements to left of index i
        // for 0 index, there are no element on left , so prod[0] = 1
        prod[0] = 1;


        for(int i=1;i<nums.length;i++){
            // prod[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            prod[i] = prod[i-1]*nums[i-1];
        }

        int ans = 1;
        for(int i=prod.length-1;i>=0;i--){
            prod[i] = prod[i] * ans;
            ans = ans * nums[i];
        }

        return prod;
    }
}
