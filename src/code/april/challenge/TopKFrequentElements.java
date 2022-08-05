package code.april.challenge;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/solution/
//TC - O(nlogk)
//SC- O(K)
public class TopKFrequentElements {

    public static void main(String args[]){

        int nums[] = {1,1,1,2,2,3};
        int k = 2;

        TopKFrequentElements obj = new TopKFrequentElements();

        int res[] = obj.topKFrequent(nums,k);

        for(int num:res){
            System.out.println(num+" ");
        }
    }
    public int[] topKFrequent(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        Map<Integer,Integer> map = new HashMap();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((entry1, entry2)->{
            return entry1.getValue()-entry2.getValue();
        });

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[] = new int[k];

        while(k-->0 && !pq.isEmpty()){
            res[k] = pq.poll().getKey();
        }

        return res;
    }
}
