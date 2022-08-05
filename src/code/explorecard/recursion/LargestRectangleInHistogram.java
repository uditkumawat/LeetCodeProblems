package code.explorecard.recursion;

//https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/1727776/JavaC%2B%2B-Explanation-going-from-Brute-to-Optimal-Approach
//https://www.youtube.com/watch?v=vcv3REtIvEo
//TC - O(N)
//SC - O(N)
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        if(heights==null || heights.length==0){
            return 0;
        }


        int n = heights.length;
        int leftSmaller[] = new int[n];
        int rightSmaller[] = new int[n];

        leftSmaller[0] = -1;
        rightSmaller[n-1] = n;


        //fill left smaller
        for(int i=1;i<heights.length;i++){

            int prev = i-1;
            while(prev>=0 && heights[prev]>=heights[i]){
                prev = leftSmaller[prev];
            }

            leftSmaller[i] = prev;
        }


        for(int i=heights.length-2;i>=0;i--){

            int prev = i+1;
            while(prev<n && heights[prev]>=heights[i]){
                prev = rightSmaller[prev];
            }

            rightSmaller[i] = prev;

        }

        int maxArea =0;

        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,(rightSmaller[i]-leftSmaller[i]-1)*heights[i]);
        }

        return maxArea;

    }


}
