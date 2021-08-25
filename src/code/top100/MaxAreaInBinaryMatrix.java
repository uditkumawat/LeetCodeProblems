package code.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxAreaInBinaryMatrix {

    public static void main(String args[]){
        int matrix[][] = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};

        System.out.println(maxAreaInBinaryMatrix(matrix));
    }

    public static int maxAreaInBinaryMatrix(int matrix[][]){

        if(matrix==null || matrix.length==0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int area = 0;

        int arr[] = new int[cols];

        //adding for first row only
        for(int i=0;i<cols;i++){
            arr[i] = matrix[0][i];
        }

        area = maxAreaInHistogram(arr);

        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    arr[i] = 0;
                }
                else{
                    arr[i] = arr[i]+matrix[i][j];
                }
            }
            area = Math.max(area,maxAreaInHistogram(arr));
        }

        return area;
    }

    public static int maxAreaInHistogram(int nums[]){

        if(nums==null || nums.length==0){
            return 0;
        }

        int n = nums.length;
        int area = Integer.MIN_VALUE;
        int left[] = new int[n];  ///nearest smaller to left
        int right[] = new int[n];   // nearest smaller to right

        left = nearestSmallerToLeft(nums,n);
        right = nearestSmallerToRight(nums,n);

        /*
        System.out.println("Nearest smaller to left");
        for(int i=0;i<n;i++){
            System.out.print(left[i]+" ");
        }
        System.out.println();

        System.out.println("Nearest smaller to right");
        for(int i=0;i<n;i++){
            System.out.print(right[i]+" ");
        }
        System.out.println();
        */

        for(int i=0;i<n;i++){
            area = Math.max(area,(right[i]-left[i]-1)*(nums[i]));
        }

        return area;
    }

    public static int[] nearestSmallerToLeft(int nums[],int n){

        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }


    public static int[] nearestSmallerToRight(int nums[],int n){

        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
}
