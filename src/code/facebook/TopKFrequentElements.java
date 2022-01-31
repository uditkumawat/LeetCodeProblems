package code.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//TC - O(Nlogk)
//SC - O(N)
public class TopKFrequentElements {

    public static void main(String args[]){

        int nums[] = {1,1,1,2,2,3};
        int k = 2;

        TopKFrequentElements obj = new TopKFrequentElements();

        int arr[] = obj.topKFrequent(nums,k);

        for(int num:arr){
            System.out.print(num+" ");
        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length){
            return nums;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return map.get(a)-map.get(b);
        });

        for(int key:map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int arr[] = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            arr[i++] = pq.poll();
        }

        return arr;
    }
}
