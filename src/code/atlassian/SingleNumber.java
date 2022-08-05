package code.atlassian;

//https://leetcode.com/problems/single-number/
//TC - O(N)
//SC - O(1)
public class SingleNumber {

    public int singleNumber(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int xor = nums[0];

        for(int i=1;i<nums.length;i++){
            xor = xor ^ nums[i];
        }

        return xor;
    }
}
