package code.blind75;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/
//TC - O(nlogk)
//SC - O(n+k) to store the hash map with not more NN elements and a heap with kk elements.
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        Map<Integer,Integer> freqMap = new HashMap();
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return freqMap.get(a)-freqMap.get(b);
        });

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            pq.add(entry.getKey());
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[] = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            res[index++] = pq.remove();
        }

        return res;
    }
}
