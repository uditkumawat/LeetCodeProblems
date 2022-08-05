package code.blind75;

//https://leetcode.com/problems/missing-number/solution/
//TC - O(N)
//SC - O(1)
public class MissingNumber {

    public int missingNumber(int[] nums) {

        int xor = nums[0];
        for(int i=1;i<nums.length;i++){
            xor = xor^nums[i];
        }

        for(int i=0;i<=nums.length;i++){
            xor = xor ^ i;
        }

        return xor;
    }
}
