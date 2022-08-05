package code.bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/solution/
//TC - O(n*2^n)
//https://www.youtube.com/watch?v=W1YmOnuTGoU
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        subsets(nums,0,res,new ArrayList<>());

        return res;
    }

    public void subsets(int nums[],int startIndex,List<List<Integer>> res,List<Integer> temp){

        if(startIndex>=nums.length){
            return;
        }

        for(int i=startIndex;i<nums.length;i++){

            if(i!=startIndex && nums[i-1]==nums[i]){
                continue;
            }
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            subsets(nums,i+1,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
