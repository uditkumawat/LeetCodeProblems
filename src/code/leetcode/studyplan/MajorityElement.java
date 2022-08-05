package code.leetcode.studyplan;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/majority-element
//TC - O(N)
//SC - O(N) and O(1)
public class MajorityElement {

    public int majorityElementI(int[] nums) {

        Map<Integer,Integer> map = new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int n = nums.length;

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>n/2){
                return entry.getKey();
            }
        }

        return -1;
    }

    public int majorityElementII(int[] nums) {

        if(nums==null || nums.length==0){
            return -1;
        }

        int count = 1;
        int elem = nums[0];

        for(int i=1;i<nums.length;i++){

            if(elem==nums[i]){
                count++;
            }
            else if(elem!=nums[i]){
                count--;
            }

            if(count==0){
                count = 1;
                elem = nums[i];
            }
        }

        return elem;
    }
}
