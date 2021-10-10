package code.leetcode.doordash;

import java.util.ArrayDeque;
import java.util.Deque;

//TC - O(N)
//SC - O(N-k+1)
public class SlidingWindowMaximum {

    public static void main(String args[]){
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k=3;

        int output[] = maxSlidingWindow(arr,k);
        for(int n:output){
            System.out.print(n+" ");
        }
        System.out.println();
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int res[] = new int[nums.length-k+1];
        int index=0;

        for(int i=0;i<nums.length;i++){

            while(!dq.isEmpty() && dq.peek()<i-k+1){
                dq.poll();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }

            dq.add(i);

            if(i>=k-1){
                res[index++] = nums[dq.peek()];
            }
        }
        return res;
    }
}
