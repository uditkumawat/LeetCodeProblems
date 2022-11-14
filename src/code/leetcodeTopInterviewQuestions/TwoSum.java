package code.leetcodeTopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/solution/
//One pass hash table solution
//TC - O(N)
//SC - O(1)
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
