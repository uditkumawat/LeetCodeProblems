package code.april.challenge;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
//TC - O(nlogk)
//SC - O(K)
public class KthLargest {


    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue();
        this.k = k;
        for(int num:nums){
            add(num);
        }
    }

    public static void main(String args[]){

        int k = 3;
        int nums[] = {4,5,8,2};
        KthLargest obj = new KthLargest(k,nums);

        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
