package code.facebook;

import java.util.Arrays;


public class HouseRobber {

    //SC - O(n)
    public int robWithSpace(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int len = nums.length;

        int dp[] = new int[len];
        Arrays.fill(dp,0);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[len-1];
    }

    public static void main(String args[]){

        int houses[] = {2,7,9,3,1};

        HouseRobber obj = new HouseRobber();

        System.out.println(obj.rob(houses));
    }

    //SC - O(1)
    public int rob(int nums[]){

        int prev1 = 0;
        int prev2 = 0;
        for(int i=0;i<nums.length;i++){
            int temp = prev1;
            prev1 = Math.max(prev2+nums[i],prev1);
            prev2 =  temp;
        }
        return prev1;
    }
}
