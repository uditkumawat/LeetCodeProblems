package code.leetcode.studyplan75;

//https://leetcode.com/problems/house-robber/
//TC - O(N)
//SC - O(1)
public class HouseRobber {

    public int rob(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }

        int prev_prev = 0;
        int prev = nums[0];
        int max = 0;

        for(int i=1;i<nums.length;i++){
            max = Math.max(prev_prev+nums[i],prev);
            prev_prev = prev;
            prev = max;
        }

        return prev;
    }
}
