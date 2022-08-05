package code.neetcode150;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/
//TC - O(nlogk)
///SC - O(K)
public class KthLargestElementInStream {

    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargestElementInStream(int k, int[] nums) {

        this.pq = new PriorityQueue<Integer>((a,b)->{
            return a-b;
        });

        this.k = k;

        for(int num:nums){

            pq.add(num);

            if(pq.size()>k){
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
