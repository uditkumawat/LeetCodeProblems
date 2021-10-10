package code.top100;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumofAllSubArraysOfSizeK {

    public static void main(String args[]){

        int arr[] ={1,6,2,3,4,1};
        int k = 3;
        int output[] = getMaxSubArray(arr,k);
        for(int num:output){
            System.out.print(num+" ");
        }
    }

    public static int[] getMaxSubArray(int arr[],int k){

        int n = arr.length;
        int output[] = new int[n-k+1];
        int index=0;
        Deque<Integer> dq = new LinkedList<Integer>();

        for(int i=0;i<arr.length;i++){
            while(!dq.isEmpty() && dq.peek()<=i-k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && arr[dq.peek()]<arr[i]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i>=k-1){
                output[index++] = arr[dq.peek()];
            }
        }
        return output;
    }
}
