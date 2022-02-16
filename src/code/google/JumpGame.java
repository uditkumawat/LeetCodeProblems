package code.google;

public class JumpGame {

    public static void main(String args[]){

        int arr[] = {3,2,1,0,4};

        JumpGame obj = new JumpGame();

        System.out.println(obj.canJump(arr));
    }
    public boolean canJump(int[] nums) {

        if(nums==null || nums.length<=1){
            return true;
        }

        int maxReach = nums[0];
        int i = 1;

        while(maxReach>=i){
            if(maxReach>=nums.length-1){
                return true;
            }
            maxReach = Math.max(nums[i]+i,maxReach);
            i++;
        }

        return false;
    }
}
