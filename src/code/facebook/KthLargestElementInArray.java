package code.facebook;

import java.util.PriorityQueue;

//TC - O(Nlogk)
public class KthLargestElementInArray {

    public static void main(String args[]){

        int arr[] = {3,2,1,5,6,4};

        KthLargestElementInArray obj = new KthLargestElementInArray();
        int k = 2;
        System.out.println(obj.findKthLargest(arr,k));
    }
    public int findKthLargest(int[] nums, int k) {

        //Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return a-b;
        });

        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.poll();

    }
}
