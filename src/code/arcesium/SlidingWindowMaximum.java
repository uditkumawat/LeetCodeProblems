package code.arcesium;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/sliding-window-maximum/submissions/
//TC - O(N)
//SC - O(N-k+1)
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        int n = nums.length;
        if(k==1){
            return nums;
        }
        int res[] = new int[n-k+1];
        int resIndex = 0;

        int right = 0;
        int index = 0;

        Deque<Integer> dq = new LinkedList();

        while(right<n){

            int curr = nums[right];

            while(!dq.isEmpty() && right-dq.peekFirst()+1>k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<curr){
                dq.removeLast();
            }

            dq.add(right);

            if(right-k+1>=0){
                res[resIndex++] = nums[dq.peekFirst()];
            }
            right++;
        }

        return res;
    }
}
