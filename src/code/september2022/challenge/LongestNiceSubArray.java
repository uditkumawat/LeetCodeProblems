package code.september2022.challenge;

//https://leetcode.com/problems/longest-nice-subarray/
//TC - O(N)
public class LongestNiceSubArray {

    public int longestNiceSubarray(int[] nums) {

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int orSum = 0;

        while(right<nums.length){

            while((orSum & nums[right])!=0){

                int startingNum = nums[left];

                //removing starting element
                orSum = orSum ^ startingNum;

                left++;
            }

            orSum = orSum | nums[right];
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }

        return maxLength;
    }
}
