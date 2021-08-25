package code.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
///TC - O(nlogk)
//SC - O(K)
public class TopKFrequentElements {

    public static void main(String args[]){
        int nums[] = {1,1,1,2,3,3,3,3,4,5,5,5,6,7};
        int k = 2;
        int arr[] = topKFrequent(nums,k);

        for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> count = new HashMap<>();
        for(int n:nums){
            count.put(n,count.getOrDefault(n,0)+1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2)->count.get(n1)-count.get(n2));

        for(int n:count.keySet()){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int arr[] = new int[k];
        for(int i=k-1;i>=0;i--){
            arr[i] = heap.poll();
        }

        return arr;
    }
}
