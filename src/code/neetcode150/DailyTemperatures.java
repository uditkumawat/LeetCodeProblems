package code.neetcode150;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/submissions/
//TC - O(N)
//SC - O(N)
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
                int prevDay = st.pop();
                res[prevDay] = i - prevDay;
            }
            st.push(i);
        }

        return res;
    }
}
