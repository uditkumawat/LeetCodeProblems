package code.leetcode.studyplan;

//https://leetcode.com/problems/house-robber/submissions/
//TC - O(N)
//SC - O(1)
public class HouseRobber {

    public int rob(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }
        int max = 0;

        if(nums.length==1){
            return nums[0];
        }

        if(nums.length==2){
            max = Math.max(nums[0],nums[1]);
            return max;
        }


        int prev = nums[0];
        int prev_prev = 0;



        for(int i=1;i<nums.length;i++){

            max = Math.max(prev,prev_prev+nums[i]);
            System.out.println(max);
            prev_prev = prev;
            prev = max;
        }

        return max;
    }
}
