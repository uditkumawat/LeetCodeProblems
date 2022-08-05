package code.neetcode150;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contains-duplicate-ii/submissions/
//TC- O(N)
//SC - O(N)
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap();

        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                if(Math.abs(i-map.get(nums[i]))<=k){
                    return true;
                }
            }

            map.put(nums[i],i);
        }

        return false;
    }
}
