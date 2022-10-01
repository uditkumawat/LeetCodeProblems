package code.salesforce;

import java.util.Stack;

//https://leetcode.com/submissions/detail/798433626/
//TC - O(N)
//SC - O(N)
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        int n = nums.length;

        Stack<Integer> stack = new Stack<Integer>();
        int result[] = new int[n];

        for(int i=2*n-1;i>=0;i--){

            while(!stack.isEmpty() && nums[i%n]>=stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i%n] = -1;
            }
            else{
                result[i%n] = stack.peek();
            }

            stack.push(nums[i%n]);
        }

        return result;
    }
}
