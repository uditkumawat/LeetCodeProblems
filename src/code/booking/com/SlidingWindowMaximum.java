package code.booking.com;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/sliding-window-maximum/
//TC - O(N)
//SC - O(N-k+1)
public class SlidingWindowMaximum {

    public static void main(String args[]){

        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMaximum obj = new SlidingWindowMaximum();

        int res[] = obj.getMax(nums,k);

        for(int num:res){
            System.out.print(num+" ");
        }
    }

    public int[] getMax(int nums[],int k){

        if(nums==null || nums.length==0 || k==0){
            return new int[0];
        }

        int n = nums.length;

        int res[] = new int[n-k+1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<nums.length;i++){

            //remove all elements which doesn't come into k size window
            while(!q.isEmpty() && q.peek()<i-k+1){
                q.poll();
            }

            //remove elements which are smaller than current one in current window
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }

            q.add(i);

            if(i>=k-1){
                res[ri++] = nums[q.peek()];
            }
        }

        return res;
    }
}
