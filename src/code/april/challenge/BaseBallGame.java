package code.april.challenge;

import java.util.Stack;

//https://leetcode.com/problems/baseball-game/solution/
//TC - O(N)
//SC - O(N)
public class BaseBallGame {

    public static void main(String args[]){

        String arr[] = {"5","-2","4","C","D","9","+","+"};

        BaseBallGame obj = new BaseBallGame();

        System.out.println(obj.calPoints(arr));
    }

    public int calPoints(String[] ops) {

        int sum = 0;

        if(ops==null || ops.length==0){
            return sum;
        }

        Stack<Integer> stack = new Stack<>();

        for(String s:ops){

            if("+".equals(s)){
                int firstValue = stack.pop();
                int secondValue = stack.pop();

                stack.push(secondValue);
                stack.push(firstValue);
                stack.push(firstValue+secondValue);
            }
            else if("C".equals(s)){
                stack.pop();
            }
            else if("D".equals(s)){
                int previous = stack.peek();
                stack.push(2*previous);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }

        while(!stack.isEmpty()){
            sum = sum + stack.pop();
        }

        return sum;
    }
}
