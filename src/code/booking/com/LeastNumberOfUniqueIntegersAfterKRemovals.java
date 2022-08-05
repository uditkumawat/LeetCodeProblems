package code.booking.com;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
//TC - O(NLogN)
//SC - O(N)
public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public static void main(String args[]){

        int nums[] = {4,3,1,1,3,3,2};

        int k = 3;

        LeastNumberOfUniqueIntegersAfterKRemovals obj = new LeastNumberOfUniqueIntegersAfterKRemovals();

        System.out.println(obj.findLeastNumOfUniqueInts(nums,k));

    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        if(arr==null || arr.length==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap();

        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1, e2)->{
            return e1.getValue()-e2.getValue();
        });

        int count = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(entry);
        }


        while(k-->0){
            Map.Entry<Integer,Integer> entry = pq.poll();
            if(entry.getValue()>1){
                pq.add(new AbstractMap.SimpleEntry<Integer, Integer>(entry.getKey(),entry.getValue()-1));
            }
        }

        count = pq.size();

        return count;
    }
}
