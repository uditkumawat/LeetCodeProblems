package code.neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/
//TC - O(n^2)
//SC - O(nlogn)
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList();

        if(nums==null || nums.length==0){
            return res;
        }

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i-1]!=nums[i]){
                checkTwoSum(nums,i,res);
            }
        }

        return res;
    }

    public void checkTwoSum(int nums[],int index,List<List<Integer>> res){

        int j = index+1;
        int k = nums.length-1;

        while(j<k){
            int sum = nums[index]+nums[j]+nums[k];

            if(sum==0){
                res.add(Arrays.asList(nums[index],nums[j],nums[k]));
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1]){
                    j++;
                }
                while(j<k && nums[k]==nums[k+1]){
                    k--;
                }
            }
            else if(sum>0){
                k--;
            }
            else{
                j++;
            }
        }
    }
}
