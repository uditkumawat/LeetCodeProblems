package code.bloomberg;

import java.util.Stack;

//https://www.youtube.com/watch?v=rKwzpADdpkY&t=657s
//https://www.youtube.com/watch?v=vcv3REtIvEo
//https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
public class LargestAreaInHistogram {

    public int largestRectangleArea(int[] heights) {

        if(heights==null || heights.length==0){
            return 0;
        }

        int len = heights.length;
        int maxArea = 0;
        int left[] = new int[len];
        int right[] = new int[len];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                left[i] = 0;
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    left[i] = 0;
                }
                else{
                    left[i] = stack.peek()+1;
                }
            }

            stack.push(i);
        }

        //imp to clear this
        stack.clear();

        for(int i=heights.length-1;i>=0;i--){
            if(stack.isEmpty()){
                right[i] = len-1;
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    right[i] = len-1;
                }
                else{
                    right[i] = stack.peek()-1;
                }
            }

            stack.push(i);
        }

        for(int i=0;i<heights.length;i++){
            maxArea = Math.max(maxArea,(right[i]-left[i]+1)*heights[i]);
        }

        return maxArea;
    }
}
