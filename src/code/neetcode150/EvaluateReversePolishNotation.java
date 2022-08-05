package code.neetcode150;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/
//TC - O(N)
//SC - O(N)
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        if(tokens==null || tokens.length==0){
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        for(String token:tokens){

            if("+-*/".contains(token)){

                int second = stack.pop();
                int first = stack.pop();

                if("+".equals(token)){
                    stack.push(first+second);
                }
                else if("-".equals(token)){
                    stack.push(first-second);
                }
                else if("*".equals(token)){
                    stack.push(first*second);
                }
                else{
                    stack.push(first/second);
                }
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
