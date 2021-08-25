package code.top100;

import java.util.ArrayDeque;
import java.util.Deque;

//TC - O(N)
//SC - O(k) deque size
public class SlidingWindowMaximum {

    static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    static int nums[];

    public static void main(String args[]){
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int output[] = maxSlidingWindow(nums,k);
        for(int n:output){
            System.out.print(n+" ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || k<0){
            return new int[0];
        }

        int n = nums.length;
        int outputIndex = 0;
        int output[] = new int[n-k+1];

        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){

            while(!q.isEmpty() && q.peek()<i-k+1){
                q.poll();
            }

            while(!q.isEmpty() && nums[q.peek()]<nums[i]){
                q.pollLast();
            }

            q.offer(i);

            if(i>=k-1){
                output[outputIndex++] = nums[q.peek()];
            }
        }

        return output;
    }
}
