package code.blind75;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/solution/
//TC - O(N)
//SC - O(1)
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap();
        int ans[] = new int[2];

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
            }
            map.put(nums[i],i);
        }

        return ans;
    }
}
