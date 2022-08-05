package code.booking.com;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElementInStream {

    private static int k;
    private PriorityQueue<Integer> pq;
    public KthLargestElementInStream(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int num:nums){
            pq.add(num);
        }

        while(pq.size()>k){
            pq.poll();
        }
    }

    public static void main(String args[]){

        int k = 3;
        int nums[] = {2,4,8,5};

        KthLargestElementInStream obj = new KthLargestElementInStream(k,nums);

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
