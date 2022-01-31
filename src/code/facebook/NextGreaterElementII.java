package code.facebook;

import java.util.Stack;

//Finding next greater element in circular array
//TC - O(2*n)
//SC - O(n)
//https://www.youtube.com/watch?v=ARkl69eBzhY
public class NextGreaterElementII {

    public static void main(String args[]){

        int nums[] = {1,2,3,4,3};

        NextGreaterElementII obj = new NextGreaterElementII();

        int res[] = obj.nextGreaterElements(nums);

        for(int num:res){
            System.out.print(num+" ");
        }
    }

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int res[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=n*2-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i%n] = -1;
            }
            else{
                res[i%n] = stack.peek();
            }

            stack.push(nums[i%n]);
        }

        return res;
    }
}
