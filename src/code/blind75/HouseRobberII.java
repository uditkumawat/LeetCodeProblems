package code.blind75;

//https://leetcode.com/problems/house-robber-ii/solution/
//TC - O(N)
//SC - O(1)
public class HouseRobberII {

    public int rob(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int sum1 = robSimple(nums,0,nums.length-2);
        int sum2 = robSimple(nums,1,nums.length-1);

        return Math.max(sum1,sum2);
    }

    public int robSimple(int nums[],int left,int right){

        int prev_prev = 0;
        int prev = 0;

        for(int i=left;i<=right;i++){
            int temp = prev;
            prev = Math.max(prev_prev+nums[i],prev);
            prev_prev = temp;
        }

        return prev;
    }
}
