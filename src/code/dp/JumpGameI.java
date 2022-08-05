package code.dp;

//https://leetcode.com/problems/jump-game/
//TC - O(n)
//SC - O(1)
//https://www.youtube.com/watch?v=lQphU-7aRaQ
//https://www.youtube.com/watch?v=muDPTDrpS28
public class JumpGameI {

    public static void main(String args[]){

        int nums[] = {3,2,1,0,4};

        JumpGameI obj = new JumpGameI();

        System.out.print(obj.canJump(nums));
    }
    public boolean canJump(int[] nums) {

        if(nums==null || nums.length==0){
            return true;
        }

        if(nums.length==1 && nums[0]==0){
            return true;
        }

        int maxReachIndex = 0+nums[0];
        int i = 1;

        while(maxReachIndex>=i){
            if(maxReachIndex>=nums.length-1){
                return true;
            }
            maxReachIndex = Math.max(nums[i]+i,maxReachIndex);
            i++;
        }

        return false;
    }
}
