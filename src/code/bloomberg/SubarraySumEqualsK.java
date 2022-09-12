package code.bloomberg;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/submissions/
//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=MHocw0bP1rA
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);

        int result = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];

            if(map.containsKey(sum-k)){
                result = result + map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return result;
    }

    /**
     * public int subarraySum(int[] nums, int k) {
     *         int count = 0, currSum = 0;
     *         HashMap<Integer, Integer> h = new HashMap();
     *
     *         for (int num : nums) {
     *             // current prefix sum
     *             currSum += num;
     *
     *             // situation 1:
     *             // continuous subarray starts
     *             // from the beginning of the array
     *             if (currSum == k)
     *                 count++;
     *
     *             // situation 2:
     *             // number of times the curr_sum − k has occured already,
     *             // determines the number of times a subarray with sum k
     *             // has occured upto the current index
     *             count += h.getOrDefault(currSum - k, 0);
     *
     *             // add the current sum
     *             h.put(currSum, h.getOrDefault(currSum, 0) + 1);
     *         }
     *
     *         return count;
     *     }
     */
}
