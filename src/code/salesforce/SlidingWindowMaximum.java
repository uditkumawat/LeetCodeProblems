package code.salesforce;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,2,9,8, 1, 0};
        int k = 5;

        System.out.println(maxSlidingWindow(arr, k));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        int n = nums.length;
        int res[] = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<Integer>();

        int index = 0;

        for(int i=0;i<n;i++){

            while(!dq.isEmpty() && dq.getFirst()<=i-k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.getLast()]<nums[i]){
                dq.removeLast();
            }

            dq.add(i);

            if(i-k+1>=0){
                res[index++] = nums[dq.getFirst()];
            }
        }

        return res;
    }
}
