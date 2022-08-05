package code.neetcode150;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
//TC - O(nlogk)
//SC - O(k)
public class KthLargestInArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return a-b;
        });

        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
