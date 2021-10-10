package code.top100;

import java.util.List;
import java.util.Stack;

public class ValidateStackSequences {

    public static void main(String args[]){

        int pushed[] = {1,2,3,4,5}, popped[] = {4,5,3,2,1};

        System.out.println(validateStackSequences(pushed,popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int j=0;
        for(int x:pushed){
            stack.push(x);

            while(!stack.isEmpty() && j<n && stack.peek()==popped[j]){
                j++;
                stack.pop();
            }
        }

        return j==n;
    }
}
