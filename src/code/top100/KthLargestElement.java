package code.top100;

import java.util.PriorityQueue;

/**
 * Time complexity : \mathcal{O}(N \log k)O(Nlogk).
 * Space complexity : \mathcal{O}(k)O(k) to store the heap elements.
 */
public class KthLargestElement {

    public static void main(String args[]){
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }
    public static int findKthLargest(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,(a, b) -> a-b);

        for(int i=0;i<nums.length;i++){
            maxHeap.add(nums[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }
}
