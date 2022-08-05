package code.may.challenge;

import java.util.Stack;

//https://www.youtube.com/watch?v=P5SE9idAHgs
//https://www.youtube.com/watch?v=GvAtQOMr8CQ
public class ShortestUnsortedContinousSubArray {

    public static void main(String args[]){

        int nums[] = {2,6,4,8,10,9,15};

        ShortestUnsortedContinousSubArray obj = new ShortestUnsortedContinousSubArray();

        System.out.print(obj.findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {

        if(nums==null || nums.length==1){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int right = 0;
        int left = nums.length;

        for(int i=0;i<nums.length;i++){
            while(!(stack.isEmpty()) && nums[stack.peek()]>nums[i]){
                left = Math.min(left,stack.pop());
            }
            stack.push(i);
        }

        stack.clear();

        for(int i=nums.length-1;i>=0;i--){
            while(!(stack.isEmpty()) && nums[stack.peek()]<nums[i]){
                right = Math.max(right,stack.pop());
            }
            stack.push(i);
        }

        return right-left>0?right-left+1:0;
    }
}
