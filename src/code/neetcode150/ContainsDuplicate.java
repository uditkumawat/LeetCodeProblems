package code.neetcode150;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/
//TC - O(N)
//SC - O(N)
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet();

        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
