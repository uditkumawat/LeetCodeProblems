package code.august2022.challenge;

import java.util.HashMap;

public class CombinationSumIV {

    private HashMap<Integer, Integer> memo;

    public int combinationSum4(int[] nums, int target) {

        memo = new HashMap<>();
        return combs(nums, target);
    }

    private int combs(int[] nums, int remain) {
        if (remain == 0)
            return 1;
        if (memo.containsKey(remain))
            return memo.get(remain);

        int result = 0;
        for (int num : nums) {
            if (remain - num >= 0){
                result += combs(nums, remain - num);
                // System.out.println(remain+" "+num);
            }
            // minor optimizaton, early stopping
            // else
            //     break;
        }
        // System.out.println("Map"+" "+remain+" "+result);
        memo.put(remain, result);
        return result;
    }
}
