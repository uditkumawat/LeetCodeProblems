package code.dp;

//https://leetcode.com/problems/house-robber/
//TC - O(N)
//SC - O(1)
public class HouseRobber {

    public static void main(String args[]){

        int nums[] = {2,7,9,3,1};

        HouseRobber obj = new HouseRobber();
        System.out.print(obj.rob(nums));
    }
    public int rob(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }


        int prev2 = nums[0];
        int prev = Math.max(nums[1],prev2);
        int res = 0;

        for(int i=2;i<nums.length;i++){
            res = Math.max(nums[i]+prev2,prev);
            prev2 = prev;
            prev = res;
        }

        return res;
    }
}
