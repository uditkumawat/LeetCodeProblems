package code.techdose;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
//TC- O(N)
//SC - O(N)
public class DailyTemperatures {

    public static void main(String args[]){

        int temp[] = {73,74,75,71,69,72,76,73};

        DailyTemperatures obj = new DailyTemperatures();

        int res[] = obj.dailyTemperatures(temp);

        for(int t:res){
            System.out.print(t+" ");
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures==null || temperatures.length==0){
            return new int[0];
        }

        int len = temperatures.length;
        int res[] = new int[len];

        Stack<Integer> stack = new Stack<>();

        for(int i=len-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = 0;
            }
            else{
                res[i] = stack.peek()-i;
            }

            stack.push(i);
        }

        return res;
    }
}
