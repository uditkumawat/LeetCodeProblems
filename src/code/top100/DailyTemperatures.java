package code.top100;

import java.util.Stack;

//TC - O(N)
//SC-O(N)
//variation of nearest greater elemetn to left
public class DailyTemperatures {

    public static void main(String args[]){

//        int temp[] = {73,74,75,71,69,72,76,73};
        int temp[] = {30,60,90};

        int output[] = dailyTemperatures(temp);

        for(int n:output){
            System.out.print(n+" ");
        }
    }
    public static int[] dailyTemperatures(int[] temperatures) {

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
