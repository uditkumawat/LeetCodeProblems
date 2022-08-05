package code.leetcode.studyplan75;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/submissions/
//TC - O(n^2)
//SC- O(1)
//https://www.youtube.com/watch?v=BS7_bRsJFiI&t=293s
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        if(nums==null || nums.length==0 || nums.length<3){
            return 0;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int closestSum = nums[len-3]+nums[len-2]+nums[len-1];
        for(int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = len-1;
            while(start<end){
                int currSum = nums[i]+nums[start]+nums[end];
                if(currSum<target){
                    start++;
                }
                else{
                    end--;
                }
                if(Math.abs(closestSum-target)>Math.abs(currSum-target)){
                    closestSum = currSum;
                }
            }
        }

        return closestSum;
    }
}
