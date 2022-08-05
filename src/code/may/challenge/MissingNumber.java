package code.may.challenge;

//https://leetcode.com/problems/missing-number/submissions/
//TC - O(N)
//SC - O(1)
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor = nums.length;

        for(int i=0;i<nums.length;i++){
            xor = xor ^ i ^ nums[i];
        }

        return xor;
    }
}
