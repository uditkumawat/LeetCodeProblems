package code.dp;

//https://leetcode.com/problems/jump-game-ii/
//TC - O(N)
//SC - O(1)
//https://www.youtube.com/watch?v=a9r98S-pDvk
public class JumpGameII {

    public static void main(String args[]){

        int nums[] = {3,2,1,0,4};

        JumpGameII obj = new JumpGameII();

        System.out.print(obj.jump(nums));
    }

    public int jump(int[] nums) {

        int currentReach = 0;
        int maxReach = 0;
        int jumps = 0;

        for(int i=0;i<nums.length-1;i++){

            //we will continously find how far we can reach in current jump
            maxReach = Math.max(nums[i]+i,maxReach);

            // if we have come to end of current jump
            //we need to make another jump
            if(i==currentReach){
                jumps++;
                currentReach = maxReach;
            }
        }

        return jumps;
    }
}
