package code.explorecard.tree;

import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/contains-duplicate-iii/
//https://www.youtube.com/watch?v=x9pdHIxHgWA
//TC - O(nlogn)
//SC - O(k)
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){

            Long num = new Long(nums[i]);

            Long floor = set.floor(num);
            Long ceil = set.ceiling(num);

            if(floor!=null && Math.abs(floor-num)<=t){
                return true;
            }


            if(ceil!=null && Math.abs(ceil-num)<=t){
                return true;
            }

            set.add(num);

            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
}
