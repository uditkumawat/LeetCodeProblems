package code.blind75;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/solution/
//TC-O(N)
//SC-O(N)
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
