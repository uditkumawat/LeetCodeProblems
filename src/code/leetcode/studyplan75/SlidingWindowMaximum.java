package code.leetcode.studyplan75;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        if(k==1){
            return nums;
        }
        int len = nums.length;

        int res[] = new int[len-k+1];
        int resIndex = 0;

        Deque<Integer> dq = new ArrayDeque<Integer>();

        for(int i=0;i<len;i++){

            while(!dq.isEmpty() && i-dq.peekFirst()+1>k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
            }

            dq.add(i);

            if(i-k+1>=0){
                res[resIndex++] = nums[dq.peekFirst()];

            }

        }

        return res;
    }
}
