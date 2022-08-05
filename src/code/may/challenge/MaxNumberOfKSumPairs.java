package code.may.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/
//TC - O(nlogn)
//SC - O(1)
public class MaxNumberOfKSumPairs {

    public static void main(String args[]){

        int nums[] = {3,1,3,4,3};
        int k = 6;

        MaxNumberOfKSumPairs obj = new MaxNumberOfKSumPairs();

        System.out.print(obj.maxOperations(nums,k));
    }
    public int maxOperations(int[] nums, int k) {

        int count = 0;

        Arrays.sort(nums);

        int left = 0;

        int right = nums.length-1;

        while(left<right){
            if(nums[left]+nums[right]<k){
                left++;
            }
            else if(nums[left]+nums[right]>k){
                right--;
            }
            else{
                left++;
                right--;
                count++;
            }
        }

        return count;
    }
}
