package code.leetcode.studyplan75;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/submissions/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temp) {

        if(temp==null || temp.length==0){
            return new int[0];
        }

        int n = temp.length;

        int res[] = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        int index = 0;

        while(index<n){

            while(!stack.isEmpty() && temp[stack.peek()]<temp[index]){
                res[stack.peek()] = index-stack.peek();
                stack.pop();
            }
            stack.push(index);
            index++;
        }

        return res;
    }
}
