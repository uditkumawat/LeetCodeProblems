package code.top100;

import java.util.Stack;

//https://www.youtube.com/watch?v=lGWLBgwd-cw&list=PLEJXowNB4kPwR6C6yq3BzS-Jkyc6XE8kE&index=20
//TC - O(N)
//SC - O(N)
public class PreviousGreaterElement {

    public static void main(String args[]){

        int arr[] = {100,80,60,70,60,75,85};

        int output[]  = getSpans(arr);

        for(int i:output){
            System.out.print(i+" ");
        }
    }

    public static int[] getSpans(int nums[]){

        int n = nums.length;
        int spans[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        spans[0] = 1;
        for(int i=1;i<nums.length;i++){

            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                int lastGreaterElementIndex = stack.peek();
                spans[i] = i-lastGreaterElementIndex;
            }
            else{
                spans[i] = 1;
            }
            stack.push(i);
        }

        return spans;
    }
}
