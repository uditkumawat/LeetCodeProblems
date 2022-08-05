package code.march.challenge;

import java.util.Stack;

//TC - O(N)
//SC - O(N)
//https://leetcode.com/problems/validate-stack-sequences/
public class ValidateStackSequences {

    public static void main(String args[]){

        int pushed[] = {1,2,3,4,5};
        int popped[] = {4,5,3,2,1};

        ValidateStackSequences obj = new ValidateStackSequences();

        System.out.println(obj.validateStackSequences(pushed,popped));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        //pointer for second array
        int j = 0;

        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);

            while(!stack.isEmpty() && j<popped.length && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }

        return j==popped.length || stack.isEmpty();
    }
}
