package code.august2022.challenge;

import java.util.TreeSet;

//https://leetcode.com/problems/longest-increasing-subsequence/submissions/
//https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308/C%2B%2BPython-DP-Binary-Search-BIT-Solutions-Picture-explain-O(NlogN)
//TC - O(nlogn)
//SC - O(n)
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        TreeSet<Integer> set = new TreeSet();

        for(int i=0;i<nums.length;i++){
            if(set.isEmpty() || set.last()<nums[i]){
                set.add(nums[i]);
            }
            else{
                set.remove(set.ceiling(nums[i]));
                set.add(nums[i]);
            }
        }

        return set.size();
    }
}
