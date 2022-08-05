package code.dp;

//https://leetcode.com/problems/house-robber-ii/solution/
//TC - O(N)
//SC - O(1)
public class HouseRobberII {

    public static void main(String args[]){

        int nums[] = {2,3,2};

        HouseRobberII obj = new HouseRobberII();

        System.out.print(obj.rob(nums));
    }

    public int rob(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return 1;
        }

        int max1 = rob(nums,0,nums.length-2);
        int max2 = rob(nums,1,nums.length-1);
        return Math.max(max1,max2);
    }

    public int rob(int[] nums,int start,int end) {

        int prev = 0;
        int prev2 = 0;

        for(int i=start;i<end;i++){

            int temp = prev;
            prev = Math.max(nums[i]+prev2,prev);
            prev2 = temp;
        }

        return prev;
    }
}
