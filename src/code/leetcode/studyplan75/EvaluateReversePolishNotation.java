package code.leetcode.studyplan75;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/
//TC- O(N)
//SC - O(N)
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();
        int val1;
        int val2;
        for(String token:tokens){

            if("+-/*".contains(token)){
                val2 = stack.pop();
                val1 = stack.pop();

                switch(token){
                    case "+":
                        stack.push(val1+val2);
                        break;
                    case "-":
                        stack.push(val1-val2);
                        break;
                    case "*":
                        stack.push(val1*val2);
                        break;
                    case "/":
                        stack.push(val1/val2);
                        break;
                }

            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
