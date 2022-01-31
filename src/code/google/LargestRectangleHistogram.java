package code.google;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String args[]){

        int arr[] = {2,1,5,6,2,3};

        LargestRectangleHistogram obj = new LargestRectangleHistogram();

        System.out.println(obj.largestRectangleArea(arr));

    }
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;

        int left[] = new int[len];
        Arrays.fill(left,0);

        int right[] = new int[len];
        Arrays.fill(right,0);

        Stack<Integer> stack = new Stack<>();

        //calculating the next smaller to right
        for(int i=0;i<len;i++){

            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                right[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        stack.clear();

        //calculating the next smaller to left
        for(int i=len-1;i>=0;i--){

            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                left[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<len;i++){
            System.out.println(right[i]+" "+left[i]+" "+heights[i]);
            maxArea = Math.max(maxArea,(right[i]-left[i]-1)*heights[i]);
        }

        return maxArea;

    }
}
