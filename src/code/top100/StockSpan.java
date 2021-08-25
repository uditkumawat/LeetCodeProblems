package code.top100;

import java.util.Stack;

//https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
public class StockSpan {

    public static void main(String args[]){

        int stockPrices[] = {100,80,60,70,60,75,85};

        int list[] = getSpans(stockPrices);

        for(int n:list){
            System.out.print(n+" ");
        }
    }

    public static int[] getSpans(int nums[]){

        int n = nums.length;

        int spans[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                spans[i] = 1;
            }
            else{
                spans[i] = i-stack.peek();
            }

            stack.push(i);
        }

        return spans;
    }
}
