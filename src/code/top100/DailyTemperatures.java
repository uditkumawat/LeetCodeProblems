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

        Stack<Integer> nge = new Stack<>();

        int n = temperatures.length;

        int output[] = new int[n];
        output[n-1] = 0;

        for(int i=n-1;i>=0;i--){

            while(!nge.isEmpty() && temperatures[nge.peek()]<temperatures[i]){
                nge.pop();
            }

            if(nge.isEmpty()){
                output[i] = 0;
            }
            else{
                output[i] = nge.peek()-i;
            }

            nge.push(i);
        }

        return output;
    }
}
