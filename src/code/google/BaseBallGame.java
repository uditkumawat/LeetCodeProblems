package code.google;

import java.util.Stack;

/**
 * You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
 *
 * At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
 *
 * An integer x - Record a new score of x.
 * "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
 * "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
 * "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
 * Return the sum of all the scores on the record.
 */
public class BaseBallGame {

    public static void main(String args[]){

        BaseBallGame obj = new BaseBallGame();
        String ops[]= {"5","-2","4","C","D","9","+","+"};
        System.out.println(obj.calPoints(ops));
    }

    public int calPoints(String[] ops) {

        if(ops==null || ops.length==0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for(String str:ops){

            if("C".equals(str)){
                stack.pop();
            }
            else if("D".equals(str)){
                stack.push(stack.peek()*2);
            }
            else if("+".equals(str)){
                int lastValue = stack.pop();
                int secondLastValue = stack.pop();
                stack.push(secondLastValue);
                stack.push(lastValue);
                stack.push(lastValue+secondLastValue);
            }
            else{
                stack.push(Integer.valueOf(str));
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
