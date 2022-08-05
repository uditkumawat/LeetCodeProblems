package code.leetcode.studyplan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/submissions
//TC - O(N^2)
//SC - O(nlogn)

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i-1]!=nums[i]){
                twoSum(nums,i,res);
            }
        }

        return res;
    }

    public void twoSum(int nums[],int i,List<List<Integer>> res){

        int left = i+1;
        int right = nums.length-1;

        while(left<right){
            int sum = nums[i] + nums[left] + nums[right];

            if(sum==0){
                res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
                while(left<right && nums[left]==nums[left-1]){
                    left++;
                }
                while(left<right && nums[right]==nums[right+1]){
                    right--;
                }
            }
            else if(sum>0){
                right--;
            }
            else{
                left++;
            }
        }
    }
}
