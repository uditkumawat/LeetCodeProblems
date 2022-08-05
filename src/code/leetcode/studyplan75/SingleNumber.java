package code.leetcode.studyplan75;

//https://leetcode.com/problems/single-number/
//TC - O(N)
//SC - O(1)
public class SingleNumber {

    public int singleNumber(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int xor = 0;

        for(int num:nums){
            xor = xor^num;
        }

        return xor;
    }
}
