package code.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 */
public class FrequencySort {

    public static void main(String args[]){
        int nums[] = {-1,1,-6,4,5,-6,1,4,1};
        FrequencySort obj = new FrequencySort();
        int output[] = obj.frequencySort(nums);

        for(int num:output){
            System.out.print(num+" ");
        }
    }
    public int[] frequencySort(int[] nums) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int num:nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b)->{
            return a.getValue()==b.getValue()?b.getKey()-a.getKey():a.getValue()-b.getValue();
        });

        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet()){
            pq.add(entry);
        }

        int index = 0;

        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> entry = pq.poll();
            int num = entry.getKey();
            int count = entry.getValue();
            while(count-->0){
                nums[index++] = num;
            }
        }

        return nums;
    }
}
