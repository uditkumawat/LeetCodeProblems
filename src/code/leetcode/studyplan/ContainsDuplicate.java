package code.leetcode.studyplan;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/submissions/
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
