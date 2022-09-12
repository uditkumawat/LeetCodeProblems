package code.neetcode150;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/submissions/
//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=bMrcBdwRh2U
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures==null || temperatures.length==0){
            return new int[0];
        }

        int len = temperatures.length;

        int res[] = new int[len];

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0;i<len;i++){

            int currentTemp = temperatures[i];

            while(!st.isEmpty() && temperatures[st.peek()]<currentTemp){
                res[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        return res;
    }
}
