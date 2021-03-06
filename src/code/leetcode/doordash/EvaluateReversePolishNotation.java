package code.leetcode.doordash;

import java.util.Stack;

//TC - O(n) -where n is number of elements in array
//Space Complexity : O(n)
//
//In the worst case, the stack will have all the numbers on it at the same time. This is never more than half the length of the input array.
public class EvaluateReversePolishNotation {

    public static void main(String args[]){
        String tokens[] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {

        if(tokens==null || tokens.length==0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){

            String str = tokens[i];

            if("+-*/".contains(str)){

                int secondValue = stack.pop();
                int firstValue = stack.pop();
                int res = 0;

                switch(str){
                    case "+":
                        res = firstValue+secondValue;
                        break;
                    case "-":
                        res = firstValue-secondValue;
                        break;
                    case "*":
                        res = firstValue*secondValue;
                        break;
                    case "/":
                        res = firstValue/secondValue;
                        break;
                }

                stack.push(res);
            }
            else{
                stack.push(Integer.valueOf(str));
            }
        }

        return stack.pop();
    }
}
