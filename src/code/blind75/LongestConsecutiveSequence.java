package code.blind75;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/submissions/
//TC - O(N)
//SC - O(N)
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Set<Integer> set = new HashSet();

        for(int num:nums){
            set.add(num);
        }

        int maxLength = 0;

        for(int num:set){

            if(!set.contains(num-1)){

                int currNum = num;
                int count = 1;

                while(set.contains(currNum+1)){
                    currNum++;
                    count++;
                }

                maxLength = Math.max(maxLength,count);
            }
        }

        return maxLength;
    }
}
